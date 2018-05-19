package example.hp.wandroid.ui.knowledgehierarchy.knowledgedetail;

import java.util.List;

import example.hp.wandroid.util.Mock;

public class KnowledgeDetailPresenter extends Contract.KnowledgeDetailPresernter<Contract.KnowledgeDetailView> {
    @Override
    void loadKnowledgeDetail() {
        List<String> datas= Mock.getDatas();
        mView.updateKnowledgeDetail(datas);


    }
}
