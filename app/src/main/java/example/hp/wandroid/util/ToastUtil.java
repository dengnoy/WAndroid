package example.hp.wandroid.util;

import android.content.Context;
import android.widget.Toast;

import example.hp.wandroid.MyApp;

public class ToastUtil {
    private static final String TAG = ToastUtil.class.getSimpleName();
    private static Context sContext = MyApp.sAPP;

    public static void shortToast(String s) {
        if (sContext != null) {
              Toast.makeText(sContext, s, Toast.LENGTH_SHORT).show();

        }
    }

}
