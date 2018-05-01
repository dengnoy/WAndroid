package example.hp.wandroid.base;

import android.view.View;

import java.util.List;

public interface BaseView extends Contract.IView {


    void onSuccess(List newDatas);//数据获取成功

    void onFailed(String error);//数据获取失败

    void onCancel(String msg);//数据获取取消

    void showLoading(String msg);

    void hiddenLoading(String msg);//隐藏加载loading

    void showNoNet(String msg);


}
