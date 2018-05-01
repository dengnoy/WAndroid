package example.hp.wandroid.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import example.hp.wandroid.R;
import example.hp.wandroid.ui.LoginActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public Toolbar mToolBar;
    private Unbinder mUnBinder;

    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public static void startIt(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        mUnBinder = ButterKnife.bind(this);
        initViews();
        setToolBar();
    }

    public abstract int getLayoutRes();

    public abstract void initViews();

    protected void setToolBar() {
        mToolBar = findViewById(R.id.toolbar);
        if (mToolBar == null)
            return;


        setSupportActionBar(mToolBar);
        customToolBar(mToolBar);
    }

    protected abstract void customToolBar(Toolbar mToolBar);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }
}
