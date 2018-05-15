package example.hp.wandroid.ui.knowledgehierarchy;

import java.util.List;

import example.hp.wandroid.base.BasePresenter;
import example.hp.wandroid.base.BaseView;
import example.hp.wandroid.bean.KnowledgeHierarchy;

public interface Constract {
  interface   KnowledgeView extends BaseView{
   void updateKnowledge(List<KnowledgeHierarchy> datas);

  }
  abstract class KnowledgePresenter<V extends KnowledgeView> extends BasePresenter<V>{
      abstract void   loadKnowledgeHierarchyData();
  }
}
