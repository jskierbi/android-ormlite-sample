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

import com.google.gson.Gson;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BaseDataType;
import com.j256.ormlite.support.DatabaseResults;
import hugo.weaving.DebugLog;

import java.sql.SQLException;

/**
 * Created by jakub on 08/06/15.
 */
public class GsonPersister extends BaseDataType {

  private static final GsonPersister SINGLETON = new GsonPersister();

  private Gson mGson = new Gson();

  public GsonPersister() {
    super(SqlType.LONG_STRING, new Class[0]); // todo what class should go here?
  }

  public static GsonPersister getSingleton() {
    return SINGLETON;
  }

  @Override
  @DebugLog
  public Object parseDefaultString(FieldType fieldType, String defaultStr) throws SQLException {
    return defaultStr;
  }

  @Override
  @DebugLog
  public Object javaToSqlArg(FieldType fieldType, Object javaObject) throws SQLException {
    // Got java object, convert it to value inserted into database
    return mGson.toJson(javaObject);
  }

  @Override
  @DebugLog
  public Object resultToSqlArg(FieldType fieldType, DatabaseResults results, int columnPos) throws SQLException {
    // Got result from database, convert it to resulting string
    return mGson.fromJson(results.getString(columnPos), fieldType.getType());
  }
}
