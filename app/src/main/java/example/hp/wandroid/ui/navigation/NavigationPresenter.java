package example.hp.wandroid.ui.navigation;

import java.util.List;

import example.hp.wandroid.bean.NavigationClassify;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.model.DataManager;
import io.reactivex.functions.Consumer;

public class NavigationPresenter extends Contract.NavigationPresenter<Contract.NavigationView> {
    @Override
    void loadNavigationDatas() {
        DataManager.getInstance().getNavigationData()
                .subscribe(new Consumer<ResponseData<List<NavigationClassify>>>() {
                    @Override
                    public void accept(ResponseData<List<NavigationClassify>> listResponseData) throws Exception {
                        if(listResponseData.getErrorCode()==0)
                            mView.updateNavigationDatas(listResponseData.getData());
                    }
                });

    }
}
