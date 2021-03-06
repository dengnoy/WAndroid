package example.hp.wandroid.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import example.hp.wandroid.ui.knowledgehierarchy.knowledgedetail.KnowledgeDetailActivity;
import example.hp.wandroid.ui.knowledgehierarchy.knowledgedetail.KnowledgedetailFragment;

public class KnowledgeDetailPagerAdapter extends FragmentPagerAdapter {


    List<String> titles=new ArrayList<>();

    public KnowledgeDetailPagerAdapter(FragmentManager fm) {
        super(fm);
        titles.add("one");
        titles.add("two");
        titles.add("three");

    }

    @Override
    public Fragment getItem(int position) {
        return KnowledgedetailFragment.getInstance(position);
    }

    // the count of pages
    @Override
    public int getCount() {
        return KnowledgeDetailActivity.mDataList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return KnowledgeDetailActivity.mDataList.get(position).getName();
    }
}
