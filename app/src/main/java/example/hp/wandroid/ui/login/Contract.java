package example.hp.wandroid.ui.login;

import example.hp.wandroid.base.BasePresenter;
import example.hp.wandroid.base.BaseView;
import example.hp.wandroid.bean.UserData;

public class Contract {

interface LoginView extends BaseView{
    void notifyLogined(UserData userData);
    void notifyRegisted();

}

abstract static class LoginPresenter<V extends LoginView> extends BasePresenter<V>{
    abstract boolean login(String userName, String password);
    abstract boolean regist(String userName, String pasword);

}
}
