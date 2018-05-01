package example.hp.wandroid.ui.main;

import java.util.List;

import example.hp.wandroid.base.BasePresenter;
import example.hp.wandroid.base.BaseView;
import example.hp.wandroid.bean.Banner;

public interface Contract {
    public interface HomeView extends BaseView {
      public  void displayBanner(List<Banner> datas);
    }

    public abstract class HomePresent<V extends HomeView> extends BasePresenter<V> {
        abstract void loadMore(int page);  //加载下页

        abstract void refreshData();  // 更新

        abstract void collectArticle(int articleId, Boolean isCollected);//收藏或取消收藏

        abstract void getBanner(); //获取banner信息

    }
}
