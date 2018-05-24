package example.hp.wandroid.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import example.hp.wandroid.constant.ApiConstant;
import example.hp.wandroid.net.cookie.CookieManager;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

/*
这个类主要对RetrofitClient进行配置

 */
@SuppressWarnings("JavaDoc")
public class RetrofitManager {
    private static RetrofitManager sInstance;
    private Retrofit mClient;
    private final String sBaseUrl = ApiConstant.sBaseUrl;
    private OkHttpClient mOkHttpClient;

    private static final long READ_TIMEOUT = 50;
    private static final long WRITE_TIMEOUT = 50;

    //TODO 定制okhttp 实现cache cookie等

    private RetrofitManager() {
        // Gson gson= new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        mOkHttpClient = new OkHttpClient.Builder()
                .cookieJar(new CookieManager())
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build();

        mClient = new Retrofit.Builder().baseUrl(sBaseUrl)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())  //数据转化
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  //call适配
                .build();


    }


    public static RetrofitManager getsInstance() {
        if (sInstance == null)
            synchronized (RetrofitManager.class) {
                if (sInstance == null) {


                    sInstance = new RetrofitManager();

                }


            }
        return sInstance;
    }

    public Retrofit retrofit() {

        return mClient;
    }

    /**
     * 获取后台访问接口
     *
     * @return
     */
    public static WAndroidApi Api() {
        return RetrofitManager.getsInstance().retrofit().create(WAndroidApi.class);
    }
}
