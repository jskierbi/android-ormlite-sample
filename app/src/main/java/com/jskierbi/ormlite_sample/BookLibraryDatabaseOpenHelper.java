package com.jskierbi.ormlite_sample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.jskierbi.ormlite_sample.model.Book;

import java.sql.SQLException;

/**
 * Created by jakub on 29/05/15.
 */
public class BookLibraryDatabaseOpenHelper extends OrmLiteSqliteOpenHelper {

  private static final String TAG = BookLibraryDatabaseOpenHelper.class.getSimpleName();

  // Has to be public!!!
  public BookLibraryDatabaseOpenHelper(Context context) {
    super(context, "books.db", null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
    try {
      TableUtils.createTable(connectionSource, Book.class);
    } catch (SQLException ex) {
      Log.e(TAG, "Exception while creating table!", ex);
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

  }
}
