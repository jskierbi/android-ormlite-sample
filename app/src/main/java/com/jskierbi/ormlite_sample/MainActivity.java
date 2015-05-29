package com.jskierbi.ormlite_sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.jskierbi.ormlite_sample.model.Account;

import java.sql.SQLException;


public class MainActivity extends ActionBarActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//    DatabaseOpenHelper helper = new DatabaseOpenHelper(getApplicationContext(), "ormlite_base", null, 1);
    DatabaseOpenHelper helper = OpenHelperManager.getHelper(this, DatabaseOpenHelper.class);
    ConnectionSource connectionSource = helper.getConnectionSource();

    try {

      Dao<Account, String> accountDao = DaoManager.createDao(connectionSource, Account.class);

      // create an instance of Account
      Account account = new Account();
      account.setName("Jim Coakley");

      // persist the account object to the database
      accountDao.create(account);

      // retrieve the account from the database by its id field (name)
      Account account2 = accountDao.queryForId("Jim Coakley");
      System.out.println("Account: " + account2.getName());

      // close the connection source
      connectionSource.close();

    } catch (SQLException ex) {
      Log.e(TAG, "SQL exception!", ex);
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
