package example.hp.wandroid.ui.knowledgehierarchy.knowledgedetail;

import java.util.List;

import example.hp.wandroid.base.BasePresenter;
import example.hp.wandroid.base.BaseView;
import example.hp.wandroid.bean.KnowledgeArticle;

public interface Contract {
    interface KnowledgeDetailView extends BaseView {
        void updateKnowledgeDetail(List<KnowledgeArticle> datas);
    }

    abstract class KnowledgeDetailPresernter<V extends KnowledgeDetailView> extends BasePresenter<V> {
        abstract void loadKnowledgeDetail(int page,int cid);
    }
}
