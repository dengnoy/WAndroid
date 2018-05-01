package example.hp.wandroid.ui.two;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.adapter.TwoAdapter;
import example.hp.wandroid.base.BaseAdapter;
import example.hp.wandroid.base.BaseFragment;
import example.hp.wandroid.util.Mock;

public class TwoFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private BaseAdapter mAdatper;

    @SuppressLint("ValidFragment")
    public TwoFragment() {
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_two;
    }




    @Override
    public void initViews(View contentview) {
        mRecyclerView = contentview.findViewById(R.id.two_recyclerview);
        setUpRecyclerView();


    }

    private void setUpRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new TwoAdapter(R.layout.item_two_recyclerview, Mock.getDatas()));
    }

}
