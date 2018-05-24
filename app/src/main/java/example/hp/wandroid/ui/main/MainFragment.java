package example.hp.wandroid.ui.main;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.adapter.HomeAdapter;
import example.hp.wandroid.base.BaseFragment;
import example.hp.wandroid.bean.Article;
import example.hp.wandroid.ui.WebActivity;
import example.hp.wandroid.util.ImageLoader;
import example.hp.wandroid.util.ToastUtil;

public class MainFragment extends BaseFragment<HomePresenter> implements Contract.HomeView {
    public RecyclerView mRecyclerView;
    public BaseQuickAdapter mAdapter;
    public SmartRefreshLayout mRefreshLayout;
    private int mCurrentPage = 0;

    private List<String> mBannerIamges = new ArrayList<String>();
    private List<String> mBannerTitles = new ArrayList<String>();
    private List<String> mBannerLinks = new ArrayList<String>();
    private int mCurBannerPage;


    public MainFragment() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }


    public void loadMore(int page) {
        mPresenter.loadMore(page);
    }

    @Override
    public void initViews(View contentview) {   //called in activityCreated()
        mRefreshLayout = contentview.findViewById(R.id.home_fragment_refreshlayout);
        mRecyclerView = contentview.findViewById(R.id.main_recyclerview);
        mPresenter = new HomePresenter();

        setupRecyclerView();  //设置recycler相关


    }

    @Override
    protected void initDatas() {
        loadMore(mCurrentPage++);
        mPresenter.getBanner();
    }

    @Override
    public void onSuccess(List newDatas) {

        mAdapter.addData(newDatas);
    }

    private void setupRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter(R.layout.item_home_articlelist, null));
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                loadMore(mCurrentPage++);
                mRefreshLayout.finishLoadMore(true);
            }
        });

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WebActivity.openUrl(getActivity(), ((Article) adapter.getItem(position)).getLink());
            }
        });
        mAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                Article item = (Article) adapter.getItem(position);//TODO  不合理
              //  item.save();
              //  ToastUtil.shortToast("已收藏");
                return true;
            }
        });




    }

    @Override
    public void displayBanner(List<example.hp.wandroid.bean.Banner> datas) {
        final Banner banner = LayoutInflater.from(getActivity()).inflate(R.layout.head_banner, null).findViewById(R.id.home_banner);
        ((ViewGroup) banner.getParent()).removeView(banner);
        for (example.hp.wandroid.bean.Banner ban : datas) {
            mBannerIamges.add(ban.getImagePath());
            mBannerTitles.add(ban.getTitle());
            mBannerLinks.add(ban.getUrl());

        }

        banner.setImages(mBannerIamges)
                .setBannerTitles(mBannerTitles)

                .setImageLoader(new ImageLoader())
                .setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
                .setIndicatorGravity(BannerConfig.CENTER)
                .start();

        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurBannerPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                WebActivity.openUrl(getActivity(), mBannerLinks.get(mCurBannerPage));
                // Log.d("Is this a url", mBannerLinks.get(position));
            }
        });
        mAdapter.addHeaderView(banner);
    }


}
