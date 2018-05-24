package example.hp.wandroid;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import example.hp.wandroid.base.BaseActivityWithMvp;
import example.hp.wandroid.model.DataManager;
import example.hp.wandroid.model.LoginHelperImp;
import example.hp.wandroid.ui.AboutActivity;
import example.hp.wandroid.ui.fav.FavActivity;
import example.hp.wandroid.ui.login.LoginActivity;
import example.hp.wandroid.ui.main.MainFragment;
import example.hp.wandroid.ui.knowledgehierarchy.KnowledgeHierarchyFragment;
import example.hp.wandroid.ui.navigation.NavigationFragment;
import example.hp.wandroid.util.ToastUtil;
import example.hp.wandroid.widget.behavior.CustomPopuoWindow;

public class MainActivity extends BaseActivityWithMvp implements View.OnClickListener {
    private DrawerLayout mDrawerLayout;   //侧滑布局
    private NavigationView mNavigationView;  //侧滑导航
    private BottomNavigationView mBottonNavigation;    //底部导航
    private ImageView mUserHeaderImg;   //用户头像
    private TextView mUserInfoTV;    //用户信息
    private Fragment[] mFragments;   //首页的fragments
    private int mCurrentFragment = -1;
    //  public static boolean mLogined = true;   //是否登录
    private TextView mToolbarTitleTV;   //toolbar标题
    private MenuItem mMenuItemLogout;  //侧滑退出菜单项

    // private String mUserInfo = "Frank";  //用户信息内容   //用户信息应该作为应用全局使用  //TODO


    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        tryAutoLogin();


        mDrawerLayout = findViewById(R.id.main_drawer);
        mToolbarTitleTV = findViewById(R.id.toolbar_tv);
        mNavigationView = findViewById(R.id.nav_view);
        mBottonNavigation = findViewById(R.id.main_bottom_nav);

        mToolbarTitleTV.setText("首页");
        initFragments();

        mNavigationView.setCheckedItem(R.id.main_menu_home);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.main_menu_home:
                        ToastUtil.shortToast("首页");
                        break;

                    case R.id.main_menu_fav:

                        if (DataManager.getInstance().isLogined())
                            FavActivity.startIt(MainActivity.this);
                        else ToastUtil.shortToast("您未登录");

                        break;
                    case R.id.main_menu_about:

                        AboutActivity.startIt(MainActivity.this);

                        break;
                    case R.id.main_menu_exit:
                        if (DataManager.getInstance().isLogined()) {
                            if (mMenuItemLogout == null)
                                mMenuItemLogout = item;
                            item.setEnabled(false);
                            ToastUtil.shortToast("退出");
                            DataManager.getInstance().setLogined(false);
                            LoginHelperImp.getInstance().setAutoLogin(false);
                            changeLoginStatus();
                        }


                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        mMenuItemLogout = mNavigationView.getMenu().getItem(3);  //获取退出按钮


        //底部导航栏设置监听
        mBottonNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main_menu_bottom_home:
                        switchFragment(0);
                        mToolbarTitleTV.setText("首页");

                        break;
                    case R.id.main_menu_bottom_knowledge:
                        switchFragment(1);
                        mToolbarTitleTV.setText("知识体系");


                        break;
                    case R.id.main_menu_bottom_daohang:
                        switchFragment(2);
                        mToolbarTitleTV.setText("导航");

                        break;
                }
                return true;
            }
        });

        mUserHeaderImg = mNavigationView.getHeaderView(0).findViewById(R.id.iv_user_header);
        mUserInfoTV = mNavigationView.getHeaderView(0).findViewById(R.id.tv_user_info);

        if (mUserInfoTV != null)
            mUserInfoTV.setOnClickListener(this);


    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void uapateUserInfo(Drawable headpic, String info) {
        mUserHeaderImg.setBackground(headpic);
        mUserInfoTV.setText(info);
    }


    @Override
    protected void customToolBar(final Toolbar toolbar) {


        ActionBar actionbar = getSupportActionBar();

        //  mToolbarTitleTV.setText("WAndroid");

        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            //actionbar.setHomeAsUpIndicator(R.drawable.drawer);


        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.START);
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_toolbar_action_search:
                        //  ToastUtil.shortToast("你点了搜索");
                        CustomPopuoWindow.showSearchPopWindow(MainActivity.this, toolbar);

                }

                return true;
            }
        });
    }

    private void initFragments() {
        mFragments = new Fragment[3];
        mFragments[0] = new MainFragment();
        mFragments[1] = new KnowledgeHierarchyFragment();
        mFragments[2] = new NavigationFragment();

        switchFragment(0);

    }

    private void switchFragment(int index) {

        if (mCurrentFragment == index)
            return;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mFragments[index].getActivity() == null) {
            // Log.d("debug+++++++++", "fragment's activity is null");   //fragment还没添加
            transaction.add(R.id.container, mFragments[index]);
        }
        for (Fragment mFragment : mFragments) {
            if (mFragment.getActivity() != null)
                transaction.hide(mFragment);
        }
        transaction.show(mFragments[index]);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);

    }

    private void changeLoginStatus() {

        boolean isLogined = DataManager.getInstance().isLogined();
        String userInfo = DataManager.getInstance().getUserName();



        if (isLogined) {
            //设置headerview的信息为登录状态
            mUserInfoTV.setText(userInfo);
            //TODO
            if (mMenuItemLogout != null)
                mMenuItemLogout.setEnabled(true);

        } else {
            //设置headerView的信息为退出状态
            //TODO
            mUserInfoTV.setText("登录");
            if (mMenuItemLogout != null) mMenuItemLogout.setEnabled(false);

        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tv_user_info:
                if (!DataManager.getInstance().isLogined())   //TODO
                    LoginActivity.startIt(this);
                mDrawerLayout.closeDrawer(Gravity.START);
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        changeLoginStatus();   //TODO
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFragments = null;
        CircularProgressDrawable d;


    }

    private void tryAutoLogin() {
        if (canLogin()) {
            if (LoginHelperImp.getInstance().isAutoLogin())
                LoginHelperImp.getInstance().tryAutoLogin();

        }

    }

    private boolean canLogin() {
        //TODO 检查网络环境  是否允许登录
        return true;
    }
}
