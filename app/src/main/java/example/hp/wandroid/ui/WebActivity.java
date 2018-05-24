package example.hp.wandroid.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;

import example.hp.wandroid.R;
import example.hp.wandroid.base.BaseActivity;

public class WebActivity extends BaseActivity {
    private static String mUrl;
    private View mWebContainer;
    private AgentWeb mAgentWeb;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_web;
    }

    public static void openUrl(Context context, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        mUrl = url;
        context.startActivity(intent);
    }

    @Override
    public void initViews() {
        mWebContainer = findViewById(R.id.web_container);
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent((LinearLayout) mWebContainer, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(mUrl);
    }

    @Override
    protected void customToolBar(Toolbar mToolBar) {

    }


    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }
}
