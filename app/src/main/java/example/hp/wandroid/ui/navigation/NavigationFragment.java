package example.hp.wandroid.ui.navigation;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.adapter.NavigationRecyclerAdapter;
import example.hp.wandroid.base.BaseFragment;
import example.hp.wandroid.bean.NavigationClassify;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class NavigationFragment extends BaseFragment<NavigationPresenter> implements Contract.NavigationView {
    private VerticalTabLayout mVerticalTabLayout;
    private RecyclerView mRecyclerView;
    private final String TAG = "navigationfragment";
    // private boolean mRightScrollEnable = true;//  解决右边滚动带动左边select，左边又带动右边滚动的的问题
    private LinearLayoutManager mLinearLayoutManager;

    private void d(String s) {
        Log.d(TAG, s);
    }


    @Override
    public void initViews(View v) {
        mVerticalTabLayout = v.findViewById(R.id.navigaiton_vertical_tablayout);
        mRecyclerView = v.findViewById(R.id.navagation_recyclerview);
        mPresenter = new NavigationPresenter();


    }

    @Override
    protected void initDatas() {
        loadDatas();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_navigation;
    }

    private void loadDatas() {
        mPresenter.loadNavigationDatas();
    }

    @Override
    public void updateNavigationDatas(List<NavigationClassify> navigationClassifyList) {
        if (navigationClassifyList == null || navigationClassifyList.isEmpty())
            return;
        setupVerticalTablayoutAdapter(navigationClassifyList);
        setupRecyclerViewAdapter(navigationClassifyList);


    }

    private void setupVerticalTablayoutAdapter(List<NavigationClassify> navigationClassifyList) {
        List<String> datas = new ArrayList<>();
        for (NavigationClassify i : navigationClassifyList) {
            datas.add(i.getName());
        }
        if (datas.isEmpty())
            return;
        TabAdapter tabAdapter = new MyTabAdapter(datas);

        mVerticalTabLayout.setTabAdapter(tabAdapter);
        mVerticalTabLayout.setVisibility(View.VISIBLE);

        mVerticalTabLayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                //   if (mRightScrollEnable)
                leftToRight(position);

                // mRightScrollEnable = true;

            }


            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });

    }

    private void leftToRight(final int position) {
        LinearLayoutManager llm = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        llm.scrollToPositionWithOffset(position, 0);

    }

    private void setupRecyclerViewAdapter(List<NavigationClassify> navigationClassifyList) {
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(new NavigationRecyclerAdapter(navigationClassifyList));
        mRecyclerView.setVisibility(View.VISIBLE);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    // mRightScrollEnable = false;
                    mVerticalTabLayout.setTabSelected(mLinearLayoutManager.findFirstVisibleItemPosition(), false);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }



    private static class MyTabAdapter implements TabAdapter {
        private List<String> mDatas;

        public MyTabAdapter(List datas) {
            mDatas = datas;
        }

        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public ITabView.TabBadge getBadge(int position) {
            return null;
        }

        @Override
        public ITabView.TabIcon getIcon(int position) {
            return null;
        }

        @Override
        public ITabView.TabTitle getTitle(int position) {
            return new ITabView.TabTitle.Builder()
                    .setContent(mDatas.get(position))
                    .setTextSize(12)

                    .build();

        }

        @Override
        public int getBackground(int position) {
            return 0;
        }
    }
}
