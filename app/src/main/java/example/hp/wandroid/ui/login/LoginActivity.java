package example.hp.wandroid.ui.login;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import example.hp.wandroid.R;
import example.hp.wandroid.base.BaseActivity;
import example.hp.wandroid.model.DataManager;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.login_et_name)
    public EditText mEtName;
    @BindView(R.id.login_et_psd)
    public EditText mEtPsd;

    @BindView(R.id.login_login)
    public Button mBtLogin;
    @BindView(R.id.login_regist)
    public Button mBtRegist;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    public void initViews() {
        mBtLogin.setOnClickListener(this);
        mBtRegist.setOnClickListener(this);


    }

    @Override
    protected void customToolBar(Toolbar mToolBar) {
        mToolBar.setTitle("登录");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_login:
                ;
            {//should check the net
                if (canLogin())
                    login();
                // showToast("用户名或密码错误，请重试！");

            }


        }
    }

    private void login() {
        DataManager.getInstance().setLogined(true);
        DataManager.getInstance().saveUserName("小美");
        DataManager.getInstance().saveUserPW("123456");
        finish();//TODO  这里直接登录成功

    }

    private boolean canLogin() {
        return true;
    }
}
