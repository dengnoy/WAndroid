package example.hp.wandroid.ui.knowledgehierarchy.knowledgedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.adapter.KnowledgeDetailAdapter;
import example.hp.wandroid.base.BaseFragment;
import example.hp.wandroid.bean.KnowledgeArticle;
import example.hp.wandroid.util.Util;

public class KnowledgedetailFragment extends BaseFragment<KnowledgeDetailPresenter> implements Contract.KnowledgeDetailView {
    SmartRefreshLayout mSmartRefreshLayout;
    RecyclerView mRecyclerView;
    BaseQuickAdapter mAdapter;
    public int mPosition = 0;   //该fragment的position
    private int mCurPage = 0;   //知识体系文章当前页


    public static KnowledgedetailFragment getInstance(int position) {
        KnowledgedetailFragment f = new KnowledgedetailFragment();
        f.mPosition = position;
        return f;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_knowledgedetail;
    }

    @Override
    public void initViews(View v) {
        super.initViews(v);
        mSmartRefreshLayout = v.findViewById(R.id.knowledge_smartrefreshlayout);
        mRecyclerView = v.findViewById(R.id.knowledge_detail_rv);
        mPresenter = new KnowledgeDetailPresenter();
        setupAdapter();


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadDatas(mCurPage, KnowledgeDetailActivity.mDataList.get(mPosition).getId());  //TODO  怎么传递cid呢？
    }

    private void loadDatas(int page, int cid) {
        if (mPresenter != null)
            mPresenter.loadKnowledgeDetail(page, cid);

    }


    private void setupAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new KnowledgeDetailAdapter(null);
        mRecyclerView.setAdapter(mAdapter);

        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                loadDatas(++mCurPage, KnowledgeDetailActivity.mDataList.get(mPosition).getId());
                refreshLayout.finishLoadMore(true);
            }
        });

    }

    @Override
    public void updateKnowledgeDetail(List<KnowledgeArticle> datas) {
        if (datas != null && datas.size() > 0)
            mAdapter.addData(datas);
        else Util.shortToast("没有更多数据");

    }

}
