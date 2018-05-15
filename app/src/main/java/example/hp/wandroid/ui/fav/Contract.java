package example.hp.wandroid.ui.fav;

import java.util.List;

import example.hp.wandroid.base.BasePresenter;
import example.hp.wandroid.base.BaseView;

import example.hp.wandroid.bean.Article;
import example.hp.wandroid.bean.FavArticle;

public interface Contract {

    public interface FavView extends BaseView {
        public void updateFavArticles(List<FavArticle.ArticleInfo> datas);
    }

    public abstract class FavPresenter<V extends FavView> extends BasePresenter<V> {

        abstract void getFavArticles(int page);//  获取收藏的文章


        abstract void collectArticle(int articleId, Boolean isCollected);//收藏或取消收藏


    }
}
