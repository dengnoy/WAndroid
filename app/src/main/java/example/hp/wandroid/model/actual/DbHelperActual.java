package example.hp.wandroid.model.actual;

import java.util.List;

import example.hp.wandroid.bean.Article;
import example.hp.wandroid.model.helper.DbHelper;

public class DbHelperActual implements DbHelper {

    @Override
    public List<Article> getFavArticlesFromDb() {
        return Article.findAll(Article.class);
    }
}
