package example.hp.wandroid.base;

public abstract class BasePresenter<V extends BaseView> implements Contract.IPresenter<V> {
    public V mView;
    protected String mTAG = null;  //用于log的TAG,设置为当前类名


    @Override
    public void Attach(V view) {
        mTAG = "==========>>>>>>>>>>" + this.getClass().getSimpleName();
        mView = view;

    }


    @Override
    public void deAtach() {
        if (mView != null)
            mView = null;
    }
}
