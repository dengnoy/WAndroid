package example.hp.wandroid.ui.knowledgehierarchy.knowledgedetail;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import example.hp.wandroid.R;
import example.hp.wandroid.adapter.KnowledgeDetailPagerAdapter;
import example.hp.wandroid.base.BaseActivity;
import example.hp.wandroid.base.BaseActivityWithMvp;

public class KnowledgeDetailActivity extends BaseActivity {

    TabLayout mTablayout;
    ViewPager mViewPager;

    FragmentPagerAdapter mPagerAdapter;


    public static void startIt(Context context, Object arg) {
        context.startActivity(new Intent(context, KnowledgeDetailActivity.class));
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_knowledgedetail;
    }

    @Override
    public void initViews() {
        mTablayout=findViewById(R.id.knowledgedetail_tablayout);
        mViewPager=findViewById(R.id.knowledgedetail_pager);
        setupAdapter();

    }

    @Override
    protected void customToolBar(Toolbar mToolBar) {

    }

    private void setupAdapter() {
        mPagerAdapter=new KnowledgeDetailPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mTablayout.setupWithViewPager(mViewPager);
        mTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTablayout.setTabGravity(Gravity.CENTER_HORIZONTAL);



    }

}
