package example.hp.wandroid;

import android.annotation.TargetApi;
import android.drm.DrmStore;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import example.hp.wandroid.base.BaseActivity;

import example.hp.wandroid.base.BaseActivityWithMvp;
import example.hp.wandroid.ui.LoginActivity;
import example.hp.wandroid.ui.main.MainFragment;
import example.hp.wandroid.ui.two.TwoFragment;
import example.hp.wandroid.util.Util;

public class MainActivity extends BaseActivityWithMvp {
    private DrawerLayout mDrawer;
    private NavigationView mNavView;
    private BottomNavigationView mBottomNav;
    private ImageView mIVHead;
    private TextView mTVNav;

    private Fragment[] mFragments;
    private int mCurrentFragment;
    private boolean mLogined;


    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        initFragments();

        mIVHead = findViewById(R.id.iv_user_header);
        mTVNav = findViewById(R.id.tv_user_info);
        mDrawer = findViewById(R.id.main_drawer);

        mNavView = findViewById(R.id.nav_view);
        mNavView.setCheckedItem(R.id.main_menu_fav);
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main_menu_fav:
                        Util.shortToast("喜欢");

                        break;
                    case R.id.main_menu_about:
                        Util.shortToast("关于");

                        break;
                    case R.id.main_menu_exit:
                        if (!mLogined) {
                            LoginActivity.startIt(MainActivity.this);
                        }
                        item.setTitle("登录");


                }
                mDrawer.closeDrawers();
                return true;
            }
        });
        mBottomNav = findViewById(R.id.main_bottom_nav);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Util.shortToast("你点了底部导航栏");
                switch (item.getItemId()) {
                    case R.id.main_menu_bottom_home:
                        switchFragment(1);
                        Util.shortToast("首页");
                        break;
                    case R.id.main_menu_bottom_knowledge:
                        switchFragment(2);
                        Util.shortToast("知识体系");
                        break;
                }
                return true;
            }
        });


    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void uapateUserInfo(Drawable headpic, String info) {
        mIVHead.setBackground(headpic);
        mTVNav.setText(info);
    }


    @Override
    protected void customToolBar(final Toolbar toolbar) {

        toolbar.setTitle("WAndroid");
        ActionBar actionbar = getSupportActionBar();

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
        mFragments[1] = new TwoFragment();

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


}
