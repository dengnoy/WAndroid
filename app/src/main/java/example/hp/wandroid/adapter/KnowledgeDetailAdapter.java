package example.hp.wandroid.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.bean.KnowledgeArticle;
import example.hp.wandroid.ui.WebActivity;

public class KnowledgeDetailAdapter extends BaseQuickAdapter {
    public KnowledgeDetailAdapter(@Nullable List data) {
        super(R.layout.item_home_articlelist,data);
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                KnowledgeArticle article= (KnowledgeArticle) getItem(position);
                WebActivity.openUrl(view.getContext(),article.getLink());
            }
        });
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        KnowledgeArticle article= (KnowledgeArticle) item;
        helper.setText(R.id.home_item_title,article.getTitle());
        helper.setText(R.id.home_item_author,article.getAuthor());
        helper.setText(R.id.home_item_time,article.getNicedate());



    }
}
