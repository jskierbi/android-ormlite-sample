package com.jskierbi.ormlite_sample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.jskierbi.ormlite_sample.model.Account;

import java.sql.SQLException;

/**
 * Created by jakub on 29/05/15.
 */
public class DatabaseOpenHelper extends OrmLiteSqliteOpenHelper {

  private static final String TAG = DatabaseOpenHelper.class.getSimpleName();

  // Has to be public!!!
  public DatabaseOpenHelper(Context context) {
    super(context, "my_super_database", null, 1);
  }

  public void release() {
    OpenHelperManager.releaseHelper();
    // Todo handle double-release
  }

//  public DatabaseOpenHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
//    super(context, databaseName, factory, databaseVersion);
//  }
//
//  public DatabaseOpenHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion, int configFileId) {
//    super(context, databaseName, factory, databaseVersion, configFileId);
//  }
//
//  public DatabaseOpenHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion, File configFile) {
//    super(context, databaseName, factory, databaseVersion, configFile);
//  }
//
//  public DatabaseOpenHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion, InputStream stream) {
//    super(context, databaseName, factory, databaseVersion, stream);
//  }

  @Override
  public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    try {
      TableUtils.createTable(connectionSource, Account.class);
    } catch (SQLException ex) {
      Log.e(TAG, "Exception while creating table!", ex);
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

  }
}
