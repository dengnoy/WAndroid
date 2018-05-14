package example.hp.wandroid.model;

import java.util.List;

import example.hp.wandroid.base.BaseView;
import example.hp.wandroid.bean.Article;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.bean.UserData;
import example.hp.wandroid.model.actual.DbHelperActual;
import example.hp.wandroid.model.actual.NetHelperActurl;
import example.hp.wandroid.model.actual.SFHelperActurl;
import example.hp.wandroid.model.helper.DbHelper;
import example.hp.wandroid.model.helper.NetHelper;
import example.hp.wandroid.model.helper.SfHelper;
import io.reactivex.Observable;

public class DataManager implements DbHelper, SfHelper, NetHelper {
    private DbHelper mDbHelper;
    private SfHelper mSfHelper;
    private NetHelper mNetHelper;

    private static DataManager sInstance;

    private DataManager(DbHelper dbHelper, SfHelper sfHelper, NetHelper netHelper) {
        mDbHelper = dbHelper;
        mSfHelper = sfHelper;
        mNetHelper = netHelper;
    }

    public static DataManager getInstance() {
        if (sInstance == null)
            synchronized (DataManager.class) {
                if (sInstance == null)
                    sInstance = new DataManager(new DbHelperActual(), new SFHelperActurl(), new NetHelperActurl());
            }
        return sInstance;
    }


    @Override
    public List<Article> getFavArticlesFromDb() {
        return mDbHelper.getFavArticlesFromDb();
    }

    @Override
    public boolean isLogined() {
        return mSfHelper.isLogined();
    }

    @Override
    public void setLogined(boolean isLogined) {
        mSfHelper.setLogined(isLogined);

    }

    @Override
    public String getUserName() {
        return mSfHelper.getUserName();
    }

    @Override
    public void saveUserName(String userName) {
        mSfHelper.saveUserName(userName);
    }

    @Override
    public String getUserPW() {
        return mSfHelper.getUserPW();
    }

    @Override
    public void saveUserPW(String password) {
        mSfHelper.saveUserPW(password);

    }

    @Override
    public void loadFromNet(BaseView view) {
        mNetHelper.loadFromNet(view);

    }

    @Override
    public Observable<ResponseData<UserData>> login(String userName, String passWord) {
        return mNetHelper.login(userName, passWord);
    }

    @Override
    public Observable<ResponseData<UserData>> regist(String userName, String passWord) {
        return mNetHelper.regist(userName, passWord);
    }
}
