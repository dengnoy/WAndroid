package example.hp.wandroid.util;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import example.hp.wandroid.MyApp;

public class Util {
    private static final String TAG = "< UTIL >";
    private static Context sContext = MyApp.sAPP;

    public static void shortToast(String s) {
        if (sContext != null) {
            //   Toast.makeText(sContext, s, Toast.LENGTH_SHORT).show();
            //  Log.d(TAG, "toast invoked");
        }
    }
}
