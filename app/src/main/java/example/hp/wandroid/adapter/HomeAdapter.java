package example.hp.wandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.base.BaseAdapter;
import example.hp.wandroid.bean.Article;
import example.hp.wandroid.bean.ArticleList;

public class HomeAdapter extends BaseAdapter {


    public HomeAdapter(int resID, List datas) {
        super(resID, datas);
    }

    @Override
    public void updateDatas(List newDatas) {

    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {

        helper.setText(R.id.home_item_title, ((Article) item).getTitle());
        helper.setText(R.id.home_item_time, ((Article) item).getNiceDate());
        helper.setText(R.id.home_item_type, ((Article) item).getChaptername());
        helper.setText(R.id.home_item_author, ((Article) item).getAuthor());



    }

}
