package example.hp.wandroid.adapter;


import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.base.BaseAdapter;

public class TwoAdapter extends BaseAdapter {


    public TwoAdapter(int resID, List datas) {
        super(resID, datas);

    }

    @Override
    public void updateDatas(List newDatas) {

    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        helper.setText(R.id.two_recycler_item_tv, (String) item);
    }
}
