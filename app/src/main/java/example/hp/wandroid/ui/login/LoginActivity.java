package example.hp.wandroid.ui.login;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import example.hp.wandroid.R;
import example.hp.wandroid.base.BaseActivityWithMvp;
import example.hp.wandroid.bean.UserData;
import example.hp.wandroid.model.DataManager;
import example.hp.wandroid.model.LoginHelperImp;
import example.hp.wandroid.util.ToastUtil;

public class LoginActivity extends BaseActivityWithMvp<Contract.LoginPresenter> implements View.OnClickListener, Contract.LoginView, CompoundButton.OnCheckedChangeListener {
    @BindView(R.id.login_et_name)  //用户输入框
    public EditText mEtName;
    @BindView(R.id.login_et_psd)   //密码输入框
    public EditText mEtPsd;

    @BindView(R.id.login_login)  //登录按钮
    public Button mBtLogin;

    @BindView(R.id.login_regist)   //注册按钮
    public TextView mTvRegist;

    @BindView(R.id.login_page_autologin)
    public CheckBox mAuthLogin; //自动登录

    @BindView(R.id.login_page_remenberpassword)
    public CheckBox mRemenberPW; //是否记住密码和用户  自动填充

    private String mUserName;//用户名
    private String mUserPassword; // 密码

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }


    @Override
    public void initViews() {
        mBtLogin.setOnClickListener(this);
        mTvRegist.setOnClickListener(this);

        //根据上次登录情况个checkbox设置状态
        mAuthLogin.setChecked(LoginHelperImp.getInstance().isAutoLogin());
        mRemenberPW.setChecked(LoginHelperImp.getInstance().isRemenberPassWord());

        mAuthLogin.setOnCheckedChangeListener(this);
        mRemenberPW.setOnCheckedChangeListener(this);

        if(LoginHelperImp.getInstance().isRemenberPassWord()){
            mEtName.setText(DataManager.getInstance().getUserName());
            mEtPsd.setText(DataManager.getInstance().getUserPW());
        }

        mEtName.setFocusable(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        mPresenter = new LoginPresenter();

    }

    @Override
    protected void customToolBar(Toolbar mToolBar) {
        getSupportActionBar().setTitle("登录");

    }

    @Override
    public void onClick(View view) {
        mUserName = mEtName.getText().toString().trim();
        mUserPassword = mEtPsd.getText().toString().trim();

        if (!inputCheck()) {
            ToastUtil.shortToast("用户或密码错误格式，重试");
            return;
        }
        switch (view.getId()) {

            case R.id.login_login:

            {//should check the net
                if (canLogin())
                    login();
                // showToast("用户名或密码错误，请重试！");

            }
            break;
            case R.id.login_regist: {
                //TODO 注册逻辑
            }
            break;


        }
    }

    private boolean inputCheck() {
        if ((mUserPassword != null && mUserPassword.length() > 5)
                &&
                (mUserName != null && mUserName.length() > 5))

            return true;
        else return false;
    }

    //TODO  登录逻辑
    private void login() {

        // DataManager.getInstance().saveUserName("小美");
        // DataManager.getInstance().saveUserPW("123456");

        mPresenter.login(mUserName, mUserPassword);//


    }

    private boolean canLogin() {
        return true;
    }

    @Override
    public void notifyLogined(UserData userData)

    {
        if (userData == null) {
            ToastUtil.shortToast("用户名或密码错误");
            return;
        }
        DataManager.getInstance().setLogined(true);
        DataManager.getInstance().saveUserName(userData.getName());
        DataManager.getInstance().saveUserPW(userData.getPassword());
        // 保存用户头像资源

        ToastUtil.shortToast("登录成功");

        finish();
    }

    @Override
    public void notifyRegisted() {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.login_page_autologin:
                LoginHelperImp.getInstance().setAutoLogin(b);
                if (b)
                    mRemenberPW.setChecked(b);


                break;

            case R.id.login_page_remenberpassword:
                LoginHelperImp.getInstance().setRemenberPassword(b);
                if(!b)
                    mAuthLogin.setChecked(b);

                break;


        }

    }
}
