package example.hp.wandroid.net;

import java.util.List;

import example.hp.wandroid.bean.ArticleList;
import example.hp.wandroid.bean.Banner;
import example.hp.wandroid.bean.ResponseData;
import retrofit2.http.GET;
import retrofit2.http.Path;
import io.reactivex.Observable;

public interface WAndroidApi {

   @GET("/article/list/{path}/json")
   Observable<ResponseData<ArticleList>> getArticleList(@Path("path") String page);

   //banner
   @GET("/banner/json")
   Observable<ResponseData<List<Banner>>>  getBanner();

}
