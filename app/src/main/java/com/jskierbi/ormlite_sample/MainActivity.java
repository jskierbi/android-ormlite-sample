package com.jskierbi.ormlite_sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.jskierbi.ormlite_sample.model.Book;
import com.jskierbi.ormlite_sample.model.Chapter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  private Dao<Book, Integer> mBookDao;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);

    ConnectionSource connectionSource = ((App) getApplication()).getDatabaseOpenHelper().getConnectionSource();
    try {
      mBookDao = DaoManager.createDao(connectionSource, Book.class);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @OnClick(R.id.btn_create_new_book)
  void createNewBookClick() {
    try {

      // create an instance of Book
      Book book = new Book();
      book.setName("Jim Coakley");

      Chapter chapter = new Chapter("Introduction", "How to use GSON persister with ORMLite");
      book.setChapter(chapter);

      List<Chapter> chapterList = new ArrayList<>();
      chapterList.add(new Chapter("One", "How to persist list"));
      chapterList.add(new Chapter("Two", "How to persist generics"));
      chapterList.add(new Chapter("Three", "Yogi bear"));

      book.setChapterList(chapterList);

      // persist the book object to the database
      mBookDao.create(book);

      Book book2 = new Book();
      book2.setName("Clark Kent");
      mBookDao.create(book2);

    } catch (SQLException ex) {
      Log.e(TAG, "SQL exception!", ex);
    }

  }

  @OnClick(R.id.btn_read_all)
  void readAllClick() {
    try {
      List<Book> bookList = mBookDao.queryForAll();
      for (Book b : bookList) {
        Log.d(TAG, "" + b);
      }
    } catch (SQLException ex) {
      Log.e(TAG, "SQL exception", ex);
    }

  }

  @OnClick(R.id.btn_delete_all)
  void deleteAllClick() {
    try {
      int deleted = mBookDao.deleteBuilder().delete();
      Log.d(TAG, "Deleted: " + deleted);
    } catch (SQLException ex) {
      Log.e(TAG, "SQL exception", ex);
    }
  }

}
