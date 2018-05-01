package example.hp.wandroid;

import android.app.Application;

public class MyApp extends Application {
    public static Application sAPP=null;

    @Override
    public void onCreate() {
        super.onCreate();
        sAPP=this;
    }
}
