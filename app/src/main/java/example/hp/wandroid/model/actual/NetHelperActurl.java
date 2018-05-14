package example.hp.wandroid.model.actual;

import example.hp.wandroid.base.BaseView;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.bean.UserData;
import example.hp.wandroid.model.helper.NetHelper;
import example.hp.wandroid.net.RetrofitManager;
import example.hp.wandroid.util.RxSchedulers;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class NetHelperActurl implements NetHelper {
    @Override
    public void loadFromNet(BaseView view) {

    }

    @Override
    public Observable<ResponseData<UserData>> login(String userName, String passWord) {
        return RetrofitManager.Api()
                .login(userName, passWord);


    }

    @Override
    public Observable<ResponseData<UserData>> regist(String userName, String passWord) {
        return RetrofitManager.Api().regist(userName, passWord, passWord);
    }

}
