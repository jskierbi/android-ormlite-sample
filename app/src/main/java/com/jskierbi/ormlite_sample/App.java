/*
 * (c) Neofonie Mobile GmbH (2015)
 *
 * This computer program is the sole property of Neofonie Mobile GmbH (http://mobile.neofonie.de)
 * and is protected under the German Copyright Act (paragraph 69a UrhG).
 *
 * All rights are reserved. Making copies, duplicating, modifying, using or distributing
 * this computer program in any form, without prior written consent of Neofonie Mobile GmbH, is prohibited.
 * Violation of copyright is punishable under the German Copyright Act (paragraph 106 UrhG).
 *
 * Removing this copyright statement is also a violation.
 */
package com.jskierbi.ormlite_sample;

import android.app.Application;

/**
 * Created by jakub on 01/06/15.
 */
public class App extends Application {

  private BookLibraryDatabaseOpenHelper mBookLibraryDatabaseOpenHelper;

  @Override
  public void onCreate() {
    mBookLibraryDatabaseOpenHelper = new BookLibraryDatabaseOpenHelper(this);
    super.onCreate();
  }

  @Override
  public void onTerminate() {
    mBookLibraryDatabaseOpenHelper.close();
    mBookLibraryDatabaseOpenHelper = null;
    super.onTerminate();
  }

  public BookLibraryDatabaseOpenHelper getDatabaseOpenHelper() {
    return mBookLibraryDatabaseOpenHelper;
  }
}
