package example.hp.wandroid.net;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

public class CookieJar implements okhttp3.CookieJar {
    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        Log.d("cookied=======", cookies.toString());
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return new ArrayList<Cookie>();
    }
}
