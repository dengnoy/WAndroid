package example.hp.wandroid.base;

public abstract class BasePresenter<V extends BaseView> implements Contract.IPresenter<V> {
   public V mView;


    @Override
    public void Attach(V view) {
        mView = view;

    }



    @Override
    public void deAtach() {
        if (mView != null)
            mView = null;
    }
}
