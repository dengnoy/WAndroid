package example.hp.wandroid.net;

import java.util.List;

import example.hp.wandroid.bean.ArticleList;
import example.hp.wandroid.bean.Banner;
import example.hp.wandroid.bean.FavArticle;
import example.hp.wandroid.bean.Hotkey;
import example.hp.wandroid.bean.KnowledgeArticle;
import example.hp.wandroid.bean.KnowledgeDetail;
import example.hp.wandroid.bean.KnowledgeHierarchy;
import example.hp.wandroid.bean.NavigationClassify;
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


    //知识体系数据
    @GET("/tree/json")
    Observable<ResponseData<List<KnowledgeHierarchy>>> loadKnowledgeHierarchyDaga();


    //体系下的文章  从0页开始
    @GET("/article/list/{page}/json")
    Observable<ResponseData<KnowledgeDetail>> loadKnowledgeArticles(@Path("page")int page, @Query("cid") int cid);

    // 导航数据
    @GET("/navi/json")
    Observable<ResponseData<List<NavigationClassify>>> getNavigationData();


    //项目分类
    @GET("project/tree/json")
    Observable projectClassfy();


    //项目列表数据


    //收藏文章列表
    @GET("/lg/collect/list/{page}/json")
    Observable<ResponseData<FavArticle>> getFavArticles(@Path("page") int page);


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
