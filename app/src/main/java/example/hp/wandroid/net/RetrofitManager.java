package example.hp.wandroid.net;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.Observable;

import example.hp.wandroid.constant.ApiConstant;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

/*
这个类主要对RetrofitClient进行配置

 */
public class RetrofitManager {
    private static RetrofitManager sInstance;
    private Retrofit mClient;
    private final String sBaseUrl = ApiConstant.sBaseUrl;

    //定制okhttp

    private RetrofitManager() {
       // Gson gson= new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        mClient = new Retrofit.Builder().baseUrl(sBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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


}
