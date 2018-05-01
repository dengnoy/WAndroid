package example.hp.wandroid.base;

import android.view.View;

public interface Contract {
    interface IView{


    }
    interface IPresenter<V extends IView>{

        void Attach(V view); //绑定
        void deAtach();   //解绑
    }

}
