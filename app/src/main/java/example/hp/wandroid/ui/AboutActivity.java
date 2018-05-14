package example.hp.wandroid.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import example.hp.wandroid.R;
import example.hp.wandroid.base.BaseActivity;

public class AboutActivity extends BaseActivity {

    private TextView mAboutTV;
    private TextView mToolBarTV;


    public static void startIt(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_about;
    }

    @Override
    public void initViews() {

        mAboutTV = findViewById(R.id.about_tv);
        mToolBarTV = findViewById(R.id.toolbar_tv);
        updateAboutInfo();
    }

    @Override
    protected void customToolBar(Toolbar mToolBar) {

        mToolBarTV.setText("About");
    }

    private void updateAboutInfo() {
        mAboutTV.setText("欢迎多多关注哦");
    }
}
