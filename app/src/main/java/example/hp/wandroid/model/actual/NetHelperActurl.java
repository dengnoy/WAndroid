package example.hp.wandroid.model.actual;

import java.util.List;

import example.hp.wandroid.base.BaseView;
import example.hp.wandroid.bean.FavArticle;
import example.hp.wandroid.bean.Hotkey;
import example.hp.wandroid.bean.KnowledgeDetail;
import example.hp.wandroid.bean.KnowledgeHierarchy;
import example.hp.wandroid.bean.NavigationClassify;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.bean.SearchArticleList;
import example.hp.wandroid.bean.UserData;
import example.hp.wandroid.model.helper.NetHelper;
import example.hp.wandroid.net.RetrofitManager;
import example.hp.wandroid.util.RxSchedulers;
import io.reactivex.Observable;

public class NetHelperActurl implements NetHelper {
    @Override
    public void loadFromNet(BaseView view) {

    }

    @Override
    public Observable<ResponseData<UserData>> login(String userName, String passWord) {
        return RetrofitManager.Api()
                .login(userName, passWord)
                .compose(RxSchedulers.<ResponseData<UserData>>applySchedulers());


    }

    @Override
    public Observable<ResponseData<UserData>> regist(String userName, String passWord) {
        return RetrofitManager.Api().regist(userName, passWord, passWord)
                .compose(RxSchedulers.<ResponseData<UserData>>applySchedulers());
    }

    @Override
    public Observable<ResponseData<FavArticle>> getFavArticle(int page) {
        return RetrofitManager.Api().getFavArticles(page)
                .compose(RxSchedulers.<ResponseData<FavArticle>>applySchedulers());
    }

    @Override
    public Observable<ResponseData<List<KnowledgeHierarchy>>> loadKnowledgeHierarchyData() {
        return RetrofitManager.Api().loadKnowledgeHierarchyDaga()
                .compose(RxSchedulers.<ResponseData<List<KnowledgeHierarchy>>>applySchedulers());
    }

    @Override
    public Observable<ResponseData<KnowledgeDetail>> loadKnowledgeArticles(int page, int cid) {
        return RetrofitManager.Api().loadKnowledgeArticles(page, cid)
                .compose(RxSchedulers.<ResponseData<KnowledgeDetail>>applySchedulers());
    }

    @Override
    public Observable<ResponseData<List<NavigationClassify>>> getNavigationData() {
        return RetrofitManager.Api().getNavigationData()
                .compose(RxSchedulers.<ResponseData<List<NavigationClassify>>>applySchedulers());
    }

    @Override
    public Observable<ResponseData<List<Hotkey>>> getHotkey() {
        return RetrofitManager.Api().getHotkey().compose(RxSchedulers.<ResponseData<List<Hotkey>>>applySchedulers());
    }

    @Override
    public Observable<ResponseData<SearchArticleList>> searchKey(int page, String key) {
        return RetrofitManager.Api().searchKey(page, key).compose(RxSchedulers.<ResponseData<SearchArticleList>>applySchedulers());
    }


}
