package example.hp.wandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import example.hp.wandroid.R;

public abstract class BaseActivityWithMvp<T extends Contract.IPresenter> extends BaseActivity implements BaseView {
    private Toolbar mToolBar = null;

    public T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (mPresenter != null)  //假如没使用注入，可以通过initviews来设置presenter
            mPresenter.Attach(this);
    }



    @Override
    protected void customToolBar(Toolbar mToolBar) {

    }

    @Override
    public void onSuccess(List newDatas) {

    }

    @Override
    public void onFailed(String error) {

    }

    @Override
    public void onCancel(String msg) {

    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hiddenLoading(String msg) {

    }

    @Override
    public void showNoNet(String msg) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.deAtach();
    }
}
