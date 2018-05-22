package example.hp.wandroid;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import org.litepal.LitePal;

public class MyApp extends Application {
    public static MyApp sAPP=null;
    private RefWatcher mRefWatcher;
    public static RefWatcher getRefWatcher(){
        return sAPP.mRefWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mRefWatcher=LeakCanary.install(this);
        LitePal.initialize(this);  //初始化litepal
        sAPP=this;
    }
}
