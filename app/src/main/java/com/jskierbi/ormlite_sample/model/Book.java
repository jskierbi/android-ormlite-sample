package com.jskierbi.ormlite_sample.model;

import com.google.gson.annotations.Expose;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.jskierbi.ormlite_sample.GsonPersister;

import java.util.List;

@DatabaseTable(tableName = "books")
public class Book {

  @DatabaseField(generatedId = true)
  @Expose(serialize = false, deserialize = false)
  private int bookId;

  @DatabaseField
  private String name;
  @DatabaseField
  private String password;

  @DatabaseField(persisterClass = GsonPersister.class)
  private Chapter chapter;

  @DatabaseField(persisterClass = GsonPersister.class)
  private List<Chapter> chapterList;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Chapter getChapter() {
    return chapter;
  }

  public void setChapter(Chapter chapter) {
    this.chapter = chapter;
  }

  public List<Chapter> getChapterList() {
    return chapterList;
  }

  public void setChapterList(List<Chapter> chapterList) {
    this.chapterList = chapterList;
  }

  @Override
  public String toString() {
    return "Book{" +
        "bookId=" + bookId +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", chapter=" + chapter +
        ", chapterList=" + chapterList +
        '}';
  }
}
