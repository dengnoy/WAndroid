package example.hp.wandroid.ui.knowledgehierarchy;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.adapter.KnowledgeAdapter;

import example.hp.wandroid.base.BaseAdapter;
import example.hp.wandroid.base.BaseFragment;
import example.hp.wandroid.bean.KnowledgeHierarchy;
import example.hp.wandroid.util.Mock;

public class KnowledgeHierarchyFragment extends BaseFragment<Constract.KnowledgePresenter> implements Constract.KnowledgeView {

    private RecyclerView mRecyclerView;
    private BaseQuickAdapter mAdatper;

    @SuppressLint("ValidFragment")
    public KnowledgeHierarchyFragment() {
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_two;
    }


    @Override
    public void initViews(View contentview) {
        mRecyclerView = contentview.findViewById(R.id.two_recyclerview);
        mPresenter = new KnowledgeHierarchyPresenter();
        setUpRecyclerView();

        loadKnowledgeHierarchyData();


    }

    private void setUpRecyclerView() {
        mAdatper = new KnowledgeAdapter(null);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdatper);

    }

    private void loadKnowledgeHierarchyData() {
        if (mPresenter != null)
            mPresenter.loadKnowledgeHierarchyData();
    }


    @Override
    public void updateKnowledge(List<KnowledgeHierarchy> datas) {
        mAdatper.addData(datas);
    }
}
