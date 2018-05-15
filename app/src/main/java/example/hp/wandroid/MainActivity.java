package example.hp.wandroid;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import example.hp.wandroid.base.BaseActivityWithMvp;
import example.hp.wandroid.model.DataManager;
import example.hp.wandroid.ui.AboutActivity;
import example.hp.wandroid.ui.fav.FavActivity;
import example.hp.wandroid.ui.login.LoginActivity;
import example.hp.wandroid.ui.main.MainFragment;
import example.hp.wandroid.ui.knowledgehierarchy.KnowledgeHierarchyFragment;
import example.hp.wandroid.util.Util;

public class MainActivity extends BaseActivityWithMvp implements View.OnClickListener {
    private DrawerLayout mDrawer;   //侧滑布局
    private NavigationView mNavView;  //侧滑导航
    private BottomNavigationView mBottomNav;    //底部导航
    private ImageView mIVHead;   //用户头像
    private TextView mTVNav;    //用户信息
    private Fragment[] mFragments;
    private int mCurrentFragment;
    //  public static boolean mLogined = true;   //是否登录
    private TextView mToolBarTV;   //toolbar标题
    private MenuItem mExitItem;  //侧滑退出菜单项

    // private String mUserInfo = "Frank";  //用户信息内容   //用户信息应该作为应用全局使用  //TODO

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        initFragments();


        mDrawer = findViewById(R.id.main_drawer);
        mToolBarTV = findViewById(R.id.toolbar_tv);
        mNavView = findViewById(R.id.nav_view);

        mNavView.setCheckedItem(R.id.main_menu_home);
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.main_menu_home:
                        Util.shortToast("首页");
                        break;

                    case R.id.main_menu_fav:

                        if (DataManager.getInstance().isLogined())
                            FavActivity.startIt(MainActivity.this);
                        else Util.shortToast("您未登录");

                        break;
                    case R.id.main_menu_about:

                        AboutActivity.startIt(MainActivity.this);

                        break;
                    case R.id.main_menu_exit:
                        if (DataManager.getInstance().isLogined()) {
                            if (mExitItem == null)
                                mExitItem = item;
                            item.setEnabled(false);
                            Util.shortToast("退出");
                            DataManager.getInstance().setLogined(false);
                            changeLoginStatus();
                        }


                }
                mDrawer.closeDrawers();
                return true;
            }
        });
        mExitItem = mNavView.getMenu().getItem(3);  //获取退出按钮
        mBottomNav = findViewById(R.id.main_bottom_nav);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                ;
                switch (item.getItemId()) {
                    case R.id.main_menu_bottom_home:
                        switchFragment(1);

                        break;
                    case R.id.main_menu_bottom_knowledge:
                        switchFragment(2);

                        break;
                }
                return true;
            }
        });
        mIVHead = mNavView.getHeaderView(0).findViewById(R.id.iv_user_header);
        mTVNav = mNavView.getHeaderView(0).findViewById(R.id.tv_user_info);

        if (mTVNav != null)
            mTVNav.setOnClickListener(this);


    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void uapateUserInfo(Drawable headpic, String info) {
        mIVHead.setBackground(headpic);
        mTVNav.setText(info);
    }


    @Override
    protected void customToolBar(final Toolbar toolbar) {


        ActionBar actionbar = getSupportActionBar();

        mToolBarTV.setText("WAndroid");

        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            //    actionbar.setHomeAsUpIndicator(R.drawable.drawer);

        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.openDrawer(Gravity.START);
            }
        });

    }

    private void initFragments() {
        mFragments = new Fragment[2];
        mFragments[0] = new MainFragment();
        mFragments[1] = new KnowledgeHierarchyFragment();

        switchFragment(1);
    }

    private void switchFragment(int index) {
        if (mCurrentFragment == index)
            return;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mFragments[index - 1].getActivity() == null) {
            Log.d("debug+++++++++", "fragment's activity is null");   //fragment还没添加
            transaction.add(R.id.container, mFragments[index - 1]);
        }
        for (int a = 0; a < mFragments.length; a++) {
            if (mFragments[a].getActivity() != null)
                transaction.hide(mFragments[a]);
        }
        transaction.show(mFragments[index - 1]);
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
        //    mLogined = isLogined;
        mTVNav.setText(userInfo);
        // mUserInfo=info;
        if (isLogined) {
            //设置headerview的信息为登录状态
            //TODO
            if (mExitItem != null)
                mExitItem.setEnabled(true);

        } else {
            //设置headerView的信息为退出状态
            //TODO
            mTVNav.setText("登录");
            if (mExitItem != null) mExitItem.setEnabled(false);

        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tv_user_info:
                if (!DataManager.getInstance().isLogined())   //TODO
                    LoginActivity.startIt(this);
                mDrawer.closeDrawer(Gravity.START);
                break;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        changeLoginStatus();   //TODO
    }
}
