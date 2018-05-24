package example.hp.wandroid.ui.main;

import android.util.Log;

import java.util.List;

import example.hp.wandroid.bean.ArticleList;
import example.hp.wandroid.bean.Banner;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.net.RetrofitManager;
import example.hp.wandroid.net.WAndroidApi;
import example.hp.wandroid.util.RxSchedulers;
import io.reactivex.functions.Consumer;


public class HomePresenter extends Contract.HomePresent<Contract.HomeView> {


    @Override
    void loadMore(int page) {
        List datas = null;

        //to get datas         should use datamanager to get datas
        Log.d("=========", "load  page = " + page);

        RetrofitManager.getsInstance().retrofit().create(WAndroidApi.class)
                .getArticleList(page + "")
                .compose(RxSchedulers.<ResponseData<ArticleList>>applySchedulers())
                .subscribe(
                        new Consumer<ResponseData<ArticleList>>() {

                            @Override
                            public void accept(ResponseData<ArticleList> articleListResponseData) throws Exception {
                                mView.onSuccess(articleListResponseData.getData().getDatas());

                                System.out.println("a data : " + articleListResponseData.getData().getDatas().get(2));
                            }
                        }
                        , new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                System.out.println("a exeption happened :");
                                System.out.println(throwable.getMessage());

                            }
                        }
                );
        //////////////////////////////
//        datas = Mock.getDatas();
////        datas.add("the last data");
////        mView.onSuccess(datas);
    }

    @Override
    void refreshData() {

    }

    @Override
    void collectArticle(int articleId, Boolean isCollected) {

    }

    @Override
    void getBanner() {
        RetrofitManager.getsInstance().retrofit().create(WAndroidApi.class).getBanner()
                .compose(RxSchedulers.<ResponseData<List<Banner>>>applySchedulers())
                .subscribe(new Consumer<ResponseData<List<Banner>>>() {
                    @Override
                    public void accept(ResponseData<List<Banner>> listResponseData) throws Exception {

                        mView.displayBanner(listResponseData.getData());
                    }
                });
    }
}
