package example.hp.wandroid.ui.login;

import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.bean.UserData;
import example.hp.wandroid.model.DataManager;
import example.hp.wandroid.util.ToastUtil;
import io.reactivex.functions.Consumer;

public class LoginPresenter extends Contract.LoginPresenter<Contract.LoginView> {
    @Override
    boolean login(String userName, String password) {
        DataManager.getInstance().login(userName, password)

                .subscribe(new Consumer<ResponseData<UserData>>() {
                    @Override
                    public void accept(ResponseData<UserData> userDataResponseData) throws Exception {
                        if (userDataResponseData.getErrorCode() == 0)
                            mView.notifyLogined(userDataResponseData.getData());
                        else ToastUtil.shortToast("登录错误");

                    }
                });


        return true;
    }

    @Override
    boolean regist(String userName, String password) {
        DataManager.getInstance().regist(userName, password)

                .subscribe(new Consumer<ResponseData<UserData>>() {
                    @Override
                    public void accept(ResponseData<UserData> userDataResponseData) throws Exception {

                    }
                });
        return true;
    }
}
