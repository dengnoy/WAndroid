package example.hp.wandroid.net;

import java.util.List;

import example.hp.wandroid.bean.ArticleList;
import example.hp.wandroid.bean.Banner;
import example.hp.wandroid.bean.Hotkey;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.bean.UserData;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import io.reactivex.Observable;
import retrofit2.http.Query;

public interface WAndroidApi {

    @GET("/article/list/{path}/json")
    Observable<ResponseData<ArticleList>> getArticleList(@Path("path") String page);

    //banner
    @GET("/banner/json")
    Observable<ResponseData<List<Banner>>> getBanner();

    //登录
    @POST("/user/login")
    @FormUrlEncoded
    Observable<ResponseData<UserData>> login(@Field("username") String userName, @Field("password") String password);

    //注册用户
    @POST("/user/register")
    Observable<ResponseData<UserData>> regist(@Field("username") String userName, @Field("password") String password, @Field("repassword") String rePassword);


    //常用网站
    @GET("/friend/json")
    Observable getUsuallySits();


    //搜索热词

    @GET("/hotkey/json")
    Observable<ResponseData<List<Hotkey>>> getHotkey();


    //体系数据
    @GET("/tree/json")
    Observable getTree();


    //体系下的文章\
    @GET("article/list/0/json?cid={id}")
    Observable hierarchyArticle(@Path("id") int id);

    // 导航数据
    @GET("/navi/json")
    Observable getNavigationData();


    //项目分类
    @GET("project/tree/json")
    Observable projectClassfy();


    //项目列表数据


    //收藏文章列表
    @GET("lg/collect/list/{page}/json")
    Observable getFavArticles(@Path("page") int page);


    //收藏站内文章


    //收藏站外文章


    //取消收藏


    //收藏网站列表

    //搜索
    @POST("article/query/{page}/json")
    Observable search(@Path("page") int page, @Query("k") String key);

    //编辑收藏网址


    //删除收藏网址

}
