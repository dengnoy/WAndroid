package example.hp.wandroid.model.helper;

import java.util.List;

import example.hp.wandroid.base.BaseView;
import example.hp.wandroid.bean.FavArticle;
import example.hp.wandroid.bean.KnowledgeArticle;
import example.hp.wandroid.bean.KnowledgeDetail;
import example.hp.wandroid.bean.KnowledgeHierarchy;
import example.hp.wandroid.bean.NavigationClassify;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.bean.UserData;
import example.hp.wandroid.net.WAndroidApi;
import example.hp.wandroid.ui.main.Contract;
import io.reactivex.Observable;

public interface NetHelper {
    public void loadFromNet(BaseView view);

    Observable<ResponseData<UserData>> login(String userName, String passWord);  //登录

    Observable<ResponseData<UserData>> regist(String userName, String passWord);  //注册用户

    Observable<ResponseData<FavArticle>> getFavArticle(int page);   //获取收藏文章列表

    Observable<ResponseData<List<KnowledgeHierarchy>>> loadKnowledgeHierarchyData();   //获取知识体系数据

    Observable<ResponseData<KnowledgeDetail>> loadKnowledgeArticles(int page, int cid); //获取知识体系二级目录的文章列表

    Observable<ResponseData<List<NavigationClassify>>> getNavigationData(); //获取导航分类

}

