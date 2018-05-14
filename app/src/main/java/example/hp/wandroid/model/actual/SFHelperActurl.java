package example.hp.wandroid.model.actual;

import example.hp.wandroid.constant.Constant;
import example.hp.wandroid.model.helper.SfHelper;
import example.hp.wandroid.util.SFUtil;

public class SFHelperActurl implements SfHelper {
    @Override
    public boolean isLogined() {
        return SFUtil.getInstance().getBoolean(Constant.KEY_FOR_ISLOGINED, false);
    }

    @Override
    public void setLogined(boolean isLogined) {
        SFUtil.getInstance().putBoolean(Constant.KEY_FOR_ISLOGINED, isLogined);
    }

    @Override
    public String getUserName() {
        return SFUtil.getInstance().getString(Constant.KEY_FOR_USERNAME, "");
    }

    @Override
    public void saveUserName(String userName) {
        SFUtil.getInstance().putString(Constant.KEY_FOR_USERNAME, userName);
    }

    @Override
    public String getUserPW() {
        return SFUtil.getInstance().getString(Constant.KEY_FOR_USERPASSWORD, "");
    }

    @Override
    public void saveUserPW(String password) {
        SFUtil.getInstance().putString(Constant.KEY_FOR_USERPASSWORD, password);
    }
}
