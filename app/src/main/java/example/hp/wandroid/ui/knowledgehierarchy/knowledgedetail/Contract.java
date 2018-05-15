package example.hp.wandroid.ui.knowledgehierarchy.knowledgedetail;

import example.hp.wandroid.base.BasePresenter;
import example.hp.wandroid.base.BaseView;

public interface Contract {
    interface KnowledgeDetailView extends BaseView {
        void updateKnowledgeDetail();
    }

    abstract class KnowledgeDetailPresernter<V extends KnowledgeDetailView> extends BasePresenter<V> {
        abstract void loadKnowledgeDetail();
    }
}
