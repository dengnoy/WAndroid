package example.hp.wandroid.util;

import android.content.Context;
import android.content.SharedPreferences;

import example.hp.wandroid.MyApp;
import example.hp.wandroid.constant.Constant;

public class SFUtil {
    private static SFUtil sInstance;  //单例模式
    private SharedPreferences mSF;

    private SFUtil(Context context) {
        mSF = context.getSharedPreferences(Constant.DEFAULT_SFFILE_NAME, 0);
    }

    public static SFUtil getInstance() {
        if (sInstance == null) {
            sInstance = new SFUtil(MyApp.sAPP);
        }
        return sInstance;
    }

    public void putString(String key, String content) {
        mSF.edit().putString(key, content).commit();

    }

    public String getString(String key, String defValue) {
        return mSF.getString(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mSF.getBoolean(key, defValue);
    }

    public void putBoolean(String key, boolean content) {
        mSF.edit().putBoolean(key, content).commit();
    }
}
