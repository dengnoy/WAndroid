package example.hp.wandroid.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.bean.SearchArticle;
import example.hp.wandroid.bean.SearchArticleList;
import example.hp.wandroid.model.DataManager;
import example.hp.wandroid.ui.WebActivity;
import example.hp.wandroid.util.ToastUtil;
import io.reactivex.functions.Consumer;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SmartRefreshLayout mSmartRefreshLayout;
    private BaseQuickAdapter mAdapter;
    private int mCurPage = 0;

    private static String mSearchKey;

    public static void startSearch(Context context, String key) {
        mSearchKey = key;
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
        ViewGroup listView; //TODO 删掉我

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_key);

        initViews();
        loadDatas();
    }

    private void loadDatas() {
        DataManager.getInstance().searchKey(mCurPage++, mSearchKey)
                .subscribe(new Consumer<ResponseData<SearchArticleList>>() {
                    @Override
                    public void accept(ResponseData<SearchArticleList> searchArticleListResponseData) throws Exception {
                        if (searchArticleListResponseData.getErrorCode() == 0) {
                            mAdapter.addData(searchArticleListResponseData.getData().getDatas());
                            if (searchArticleListResponseData.getData().getDatas().isEmpty())
                                ToastUtil.shortToast("没有啦..");
                        }

                    }
                });

    }

    private void initViews() {
        mSmartRefreshLayout = findViewById(R.id.search_page_smartrefreshlayout);
        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                loadDatas();
                refreshLayout.finishLoadMore(true);
            }
        });

        mRecyclerView = findViewById(R.id.search_key_activity_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter(null);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WebActivity.openUrl(view.getContext(), ((SearchArticle) adapter.getItem(position)).getLink());
            }
        });


    }

    private static class MyAdapter extends BaseQuickAdapter<SearchArticle, BaseViewHolder> {
        public MyAdapter(@Nullable List data) {
            super(R.layout.item_home_articlelist, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, SearchArticle item) {
            helper.setText(R.id.home_item_title, item.getTitle())
                    .setText(R.id.home_item_author, item.getAuthor())
                    .setText(R.id.home_item_time, item.getNiceDate());

        }
    }
}
