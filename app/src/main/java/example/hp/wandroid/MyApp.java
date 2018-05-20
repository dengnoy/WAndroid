package example.hp.wandroid;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import org.litepal.LitePal;

public class MyApp extends Application {
    public static Application sAPP=null;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        LitePal.initialize(this);  //初始化litepal
        sAPP=this;
    }
}
