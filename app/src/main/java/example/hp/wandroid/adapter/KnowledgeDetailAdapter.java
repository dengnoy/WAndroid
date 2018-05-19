package example.hp.wandroid.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import example.hp.wandroid.R;

public class KnowledgeDetailAdapter extends BaseQuickAdapter {
    public KnowledgeDetailAdapter(@Nullable List data) {
        super(R.layout.item_knowledgedetail,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {

    }
}
