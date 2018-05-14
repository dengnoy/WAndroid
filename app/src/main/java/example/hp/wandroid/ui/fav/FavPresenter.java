package example.hp.wandroid.ui.fav;

import example.hp.wandroid.model.DataManager;

import static example.hp.wandroid.model.DataManager.getInstance;

public class FavPresenter extends Contract.FavPresenter<Contract.FavView> {
    @Override
    void getFavArticles() {
        mView.updateFavArticles(DataManager.getInstance().getFavArticlesFromDb());
    }

    @Override
    void collectArticle(int articleId, Boolean isCollected) {

    }
}
