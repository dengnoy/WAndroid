package example.hp.wandroid.ui.fav;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.adapter.FavAdapter;
import example.hp.wandroid.base.BaseActivity;
import example.hp.wandroid.base.BaseActivityWithMvp;
import example.hp.wandroid.bean.Article;
import example.hp.wandroid.bean.ArticleList;
import example.hp.wandroid.ui.WebActivity;

public class FavActivity extends BaseActivityWithMvp<FavPresenter> implements Contract.FavView {


    private TextView mToolbarTitle;
    private RecyclerView mRecyclerViewFav; //收藏展示列表
    private BaseQuickAdapter mAdapter;


    public static void startIt(Context context) {
        context.startActivity(new Intent(context, FavActivity.class));
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_fav;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadFavArticles();  //加载数据
    }

    @Override
    public void initViews() {
        mToolbarTitle = findViewById(R.id.toolbar_tv);

        mRecyclerViewFav = findViewById(R.id.fav_recyclerview);
        mRecyclerViewFav.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FavAdapter(R.layout.item_home_articlelist, null);
        mRecyclerViewFav.setAdapter(mAdapter);
        mPresenter = new FavPresenter();

        setListener();

    }

    private void setListener() {
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WebActivity.openUrl(FavActivity.this, ((Article) adapter.getItem(position)).getLink());
            }
        });
    }

    @Override
    protected void customToolBar(Toolbar mToolBar) {
        mToolbarTitle.setText("我的收藏");
    }

    private void loadFavArticles() {
        if (mPresenter != null)
            mPresenter.getFavArticles();

    }

    @Override
    public void updateFavArticles(List<Article> datas) {
        mAdapter.addData(datas);
    }
}
