package example.hp.wandroid.model.actual;

import java.util.List;

import example.hp.wandroid.base.BaseView;
import example.hp.wandroid.bean.FavArticle;
import example.hp.wandroid.bean.KnowledgeArticle;
import example.hp.wandroid.bean.KnowledgeDetail;
import example.hp.wandroid.bean.KnowledgeHierarchy;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.bean.UserData;
import example.hp.wandroid.model.helper.NetHelper;
import example.hp.wandroid.net.RetrofitManager;
import example.hp.wandroid.util.RxSchedulers;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

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


}
