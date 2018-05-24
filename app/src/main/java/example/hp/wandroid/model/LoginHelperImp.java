package example.hp.wandroid.model;

import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.bean.UserData;
import example.hp.wandroid.constant.Constant;
import example.hp.wandroid.model.helper.LoginHelper;
import example.hp.wandroid.util.SFUtil;
import example.hp.wandroid.util.ToastUtil;
import io.reactivex.functions.Consumer;

public class LoginHelperImp implements LoginHelper {
    private volatile static LoginHelper sInstance;

    private LoginHelperImp() {
    }

    @Override
    public boolean isAutoLogin() {
        return SFUtil.getInstance().getBoolean(Constant.KEY_FOR_IS_AUTOLOGIN, false);

    }

    @Override
    public void setAutoLogin(boolean doAutoLogin) {
        SFUtil.getInstance().putBoolean(Constant.KEY_FOR_IS_AUTOLOGIN, doAutoLogin);

    }

    @Override
    public boolean isRemenberPassWord() {
        boolean remenber = SFUtil.getInstance().getBoolean(Constant.KEY_FOR_IS_REMENBER_PASSWORD, false);
        return remenber;
    }

    @Override
    public void setRemenberPassword(boolean doRemenber) {
        SFUtil.getInstance().putBoolean(Constant.KEY_FOR_IS_REMENBER_PASSWORD, doRemenber);
    }

    @Override
    public void tryAutoLogin() {
        String name = DataManager.getInstance().getUserName();
        String pw = DataManager.getInstance().getUserPW();
        if (checkLoginInfo(name, pw)) {
            DataManager.getInstance().login(name, pw)
                    .subscribe(new Consumer<ResponseData<UserData>>() {
                        @Override
                        public void accept(ResponseData<UserData> userDataResponseData) throws Exception {
                            if (userDataResponseData.getErrorCode() == 0){
                                DataManager.getInstance().setLogined(true);
                                ToastUtil.shortToast("已经自动登录");
                            }
                        }
                    });

        }


    }

    private boolean checkLoginInfo(String userName, String password) {
        boolean ok = false;
        if (userName.length() > 5 && password.length() > 0)
            ok = true;
        return ok;
    }

    public static LoginHelper getInstance() {
        if (sInstance == null)
            synchronized (LoginHelperImp.class) {
                if (sInstance == null)
                    sInstance = new LoginHelperImp();


            }
        return sInstance;
    }

}
