package example.hp.wandroid.ui.fav;

import android.util.Log;

import example.hp.wandroid.bean.FavArticle;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.model.DataManager;
import io.reactivex.functions.Consumer;

import static example.hp.wandroid.model.DataManager.getInstance;

public class FavPresenter extends Contract.FavPresenter<Contract.FavView> {

    @Override
    void getFavArticles(int page) {
        //mView.updateFavArticles(DataManager.getInstance().getFavArticlesFromDb());
        DataManager.getInstance().getFavArticle(page)
                .subscribe(new Consumer<ResponseData<FavArticle>>() {
                    @Override
                    public void accept(ResponseData<FavArticle> favArticleResponseData) throws Exception {
                        if (favArticleResponseData.getErrorCode() == 0) {
                            Log.d(mTAG, favArticleResponseData.getData().getArticleInfo().toString());
                            mView.updateFavArticles(favArticleResponseData.getData().getArticleInfo());

                        }
                    }
                });

    }

    @Override
    void collectArticle(int articleId, Boolean isCollected) {

    }
}
