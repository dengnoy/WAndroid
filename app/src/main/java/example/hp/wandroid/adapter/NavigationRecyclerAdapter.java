package example.hp.wandroid.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.bean.NavigationClassify;
import example.hp.wandroid.ui.WebActivity;

public class NavigationRecyclerAdapter extends BaseQuickAdapter<NavigationClassify, BaseViewHolder> {
    public NavigationRecyclerAdapter(@Nullable List<NavigationClassify> data) {
        super(R.layout.item_navigation_recyclerview, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NavigationClassify item) {
        helper.setText(R.id.navigation_recycler_item_capital, item.getName());
        helper.setTextColor(R.id.navigation_recycler_item_capital,Color.parseColor("#ff0000"));

        TagFlowLayout flowLayout = helper.getView(R.id.navigation_recycler_item_flowlayout);
        flowLayout.setAdapter(new FlowAdapter(item.getArticles()));
        flowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
               String link= (String) ((ViewGroup)view).getChildAt(0).getTag();
               WebActivity.openUrl(parent.getContext(),link);
               return true;
            }
        });

    }

    private static class FlowAdapter extends TagAdapter<NavigationClassify.NavigationClassifyArticle> {
        public FlowAdapter(List datas) {
            super(datas);
        }

        @Override
        public View getView(FlowLayout parent, int position, final NavigationClassify.NavigationClassifyArticle item) {
            TextView v = new TextView(parent.getContext());
            v.setPadding(10, 2, 10, 1);
            //v.setBackgroundColor(Color.parseColor("#ff0000"));
            v.setBackgroundResource(R.drawable.navigation_sharpe);

            v.setText(item.getTitle());
            v.setTag(item.getLink());



            return v;
        }
    }


}
