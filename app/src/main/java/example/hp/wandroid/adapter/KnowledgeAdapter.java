package example.hp.wandroid.adapter;


import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.base.BaseAdapter;
import example.hp.wandroid.bean.KnowledgeHierarchy;
import example.hp.wandroid.ui.knowledgehierarchy.knowledgedetail.KnowledgeActivity;

public class KnowledgeAdapter extends BaseQuickAdapter {


    public KnowledgeAdapter(List datas) {
        super(R.layout.item_knowledgehierarchy, datas);
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                KnowledgeActivity.startIt(view.getContext(), null);
            }
        });

    }


    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        KnowledgeHierarchy vItem = (KnowledgeHierarchy) item;
        helper.setText(R.id.item_knowledge_tv_title, vItem.getName());

        helper.setText(R.id.item_knowledge_tv_classify_two, vItem.getChildrenNameMerge());
    }
}
