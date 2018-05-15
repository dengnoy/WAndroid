package example.hp.wandroid.ui.knowledgehierarchy.knowledgedetail;

import android.content.Context;
import android.content.Intent;

import example.hp.wandroid.R;
import example.hp.wandroid.base.BaseActivityWithMvp;

public class KnowledgeActivity extends BaseActivityWithMvp<Contract.KnowledgeDetailPresernter> implements Contract.KnowledgeDetailView {

    public static void startIt(Context context, Object arg) {
        context.startActivity(new Intent(context, KnowledgeActivity.class));
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_knowledgedetail;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void updateKnowledgeDetail() {

    }
}
