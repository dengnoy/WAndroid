package example.hp.wandroid.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.bean.FavArticle;
import example.hp.wandroid.ui.WebActivity;

public class FavAdapter extends BaseQuickAdapter {
    public FavAdapter(List datas) {
        super(R.layout.item_home_articlelist, datas);
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                FavArticle.ArticleInfo item = (FavArticle.ArticleInfo) getItem(position);
                WebActivity.openUrl(view.getContext(), item.getLink());
            }
        });
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        helper.setText(R.id.home_item_title, ((FavArticle.ArticleInfo) item).getTitle());
        helper.setText(R.id.home_item_time, ((FavArticle.ArticleInfo) item).getNicedate());
        helper.setText(R.id.home_item_type, ((FavArticle.ArticleInfo) item).getChaptername());
        helper.setText(R.id.home_item_author, ((FavArticle.ArticleInfo) item).getAuthor());

    }
}
