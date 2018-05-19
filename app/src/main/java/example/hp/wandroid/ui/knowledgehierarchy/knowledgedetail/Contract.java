package example.hp.wandroid.ui.knowledgehierarchy.knowledgedetail;

import java.util.List;

import example.hp.wandroid.base.BasePresenter;
import example.hp.wandroid.base.BaseView;

public interface Contract {
    interface KnowledgeDetailView extends BaseView {
        void updateKnowledgeDetail(List<String> datas);
    }

    abstract class KnowledgeDetailPresernter<V extends KnowledgeDetailView> extends BasePresenter<V> {
        abstract void loadKnowledgeDetail();
    }
}
