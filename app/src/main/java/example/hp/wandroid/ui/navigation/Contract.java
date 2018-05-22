package example.hp.wandroid.ui.navigation;

import java.util.List;

import example.hp.wandroid.base.BasePresenter;
import example.hp.wandroid.base.BaseView;
import example.hp.wandroid.bean.NavigationClassify;

public interface Contract {
    interface NavigationView extends BaseView{
        void updateNavigationDatas(List<NavigationClassify> navigationClassifyList);
    }

    abstract class NavigationPresenter<V extends NavigationView> extends BasePresenter<V>{
        abstract void loadNavigationDatas();

    }
}
