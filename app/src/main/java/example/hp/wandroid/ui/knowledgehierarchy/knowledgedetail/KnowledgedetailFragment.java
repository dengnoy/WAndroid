package example.hp.wandroid.ui.knowledgehierarchy.knowledgedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.adapter.KnowledgeDetailAdapter;
import example.hp.wandroid.base.BaseFragment;

public class KnowledgedetailFragment extends BaseFragment<KnowledgeDetailPresenter> implements Contract.KnowledgeDetailView {

    RecyclerView mRecyclerView;
    BaseQuickAdapter mAdapter;

    public static KnowledgedetailFragment getInstance() {
        return new KnowledgedetailFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_knowledgedetail;
    }

    @Override
    public void initViews(View v) {
        super.initViews(v);
        mRecyclerView=v.findViewById(R.id.knowledge_detail_rv);
        mPresenter=new KnowledgeDetailPresenter();
        setupAdapter();


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadDatas();
    }

    private void loadDatas() {
        if(mPresenter!=null)
            mPresenter.loadKnowledgeDetail();

    }


    private void setupAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mAdapter=new KnowledgeDetailAdapter(null);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void updateKnowledgeDetail(List<String> datas) {
        mAdapter.addData(datas);

    }

}
