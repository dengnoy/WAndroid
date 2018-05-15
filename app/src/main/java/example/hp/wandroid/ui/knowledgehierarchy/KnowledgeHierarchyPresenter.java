package example.hp.wandroid.ui.knowledgehierarchy;

import java.util.List;

import example.hp.wandroid.bean.KnowledgeHierarchy;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.model.DataManager;
import io.reactivex.functions.Consumer;

public class KnowledgeHierarchyPresenter extends Constract.KnowledgePresenter<Constract.KnowledgeView> {
    @Override
    void loadKnowledgeHierarchyData() {
        DataManager.getInstance().loadKnowledgeHierarchyData()
                .subscribe(new Consumer<ResponseData<List<KnowledgeHierarchy>>>() {
                    @Override
                    public void accept(ResponseData<List<KnowledgeHierarchy>> knowledgeHierarchyResponseData) throws Exception {
                        if (knowledgeHierarchyResponseData.getErrorCode() == 0)
                            mView.updateKnowledge(knowledgeHierarchyResponseData.getData());
                    }
                });

    }
}
