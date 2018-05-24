package example.hp.wandroid.ui.knowledgehierarchy.knowledgedetail;

import example.hp.wandroid.bean.KnowledgeDetail;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.model.DataManager;
import io.reactivex.functions.Consumer;

public class KnowledgeDetailPresenter extends Contract.KnowledgeDetailPresernter<Contract.KnowledgeDetailView> {
    @Override
    void loadKnowledgeDetail(int page,int cid) {

        DataManager.getInstance().loadKnowledgeArticles(page,cid)
                .subscribe(new Consumer<ResponseData<KnowledgeDetail>>() {
                    @Override
                    public void accept(ResponseData<KnowledgeDetail> listResponseData) throws Exception {
                       if (listResponseData.getErrorCode()==0)
                           mView.updateKnowledgeDetail(listResponseData.getData().getDatas());
                    }
                });



    }
}
