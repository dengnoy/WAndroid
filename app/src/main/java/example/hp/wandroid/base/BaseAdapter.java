package example.hp.wandroid.base;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

public abstract class BaseAdapter extends BaseQuickAdapter {
    public BaseAdapter(int resId,List datas){
        super(resId,datas);
    }
    public abstract void updateDatas(List newDatas);
}
