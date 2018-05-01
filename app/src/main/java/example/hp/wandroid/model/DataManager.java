package example.hp.wandroid.model;

import example.hp.wandroid.base.BaseView;

import example.hp.wandroid.model.helper.DbHelper;
import example.hp.wandroid.model.helper.NetHelper;
import example.hp.wandroid.model.helper.SfHelper;

public class DataManager  {
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
                    sInstance = new DataManager(null, null, null);
            }
        return sInstance;
    }


}
