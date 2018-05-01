package example.hp.wandroid.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseFragment<T extends Contract.IPresenter> extends Fragment implements BaseView {
    private View mContentView;
    public T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mContentView = inflater.inflate(getLayoutId(), container, false);
        return mContentView;
    }


    public void initViews(View v) {

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initViews(mContentView);
        if (mPresenter != null)
            mPresenter.Attach(this);
        super.onActivityCreated(savedInstanceState);
    }

    protected abstract int getLayoutId();


    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null)
            mPresenter.deAtach();
    }

}