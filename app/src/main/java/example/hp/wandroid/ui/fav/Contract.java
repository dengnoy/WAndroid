package example.hp.wandroid.ui.fav;

import java.util.List;

import example.hp.wandroid.base.BasePresenter;
import example.hp.wandroid.base.BaseView;

import example.hp.wandroid.bean.Article;

public interface Contract {

    public interface FavView extends BaseView {
        public void updateFavArticles(List<Article> datas);
    }

    public abstract class FavPresenter<V extends FavView> extends BasePresenter<V> {

        abstract void getFavArticles();//  获取收藏的文章


        abstract void collectArticle(int articleId, Boolean isCollected);//收藏或取消收藏


    }
}
