package com.example.latte.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by mac on 2017/10/8.
 */


public class DatabaseManager {

    private static final String TAG = DatabaseManager.class.getSimpleName();
    private DaoSession mDaoSession = null;
    private UserProfileDao mDao = null;


    public DatabaseManager() {
    }

    public DatabaseManager init(Context context) {
        initDao(context);
        return this;
    }

    private static final class Holder {
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }

    public static DatabaseManager getInstance() {
        return Holder.INSTANCE;
    }

    private void initDao(Context context) {
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context, "fast_ec.db");
        final Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mDao = mDaoSession.getUserProfileDao();

    }

    public final UserProfileDao getDao() {
        return mDao;
    }

}
