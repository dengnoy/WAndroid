package example.hp.wandroid.model.helper;

import java.util.List;

import example.hp.wandroid.bean.Article;

public interface DbHelper {
    List<Article> getFavArticlesFromDb();
}
