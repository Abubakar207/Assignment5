package com.example.assignment_4.Room;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DaoClass_Impl implements DaoClass {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<City> __insertionAdapterOfCity;

  private final EntityInsertionAdapter<Weather> __insertionAdapterOfWeather;

  public DaoClass_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCity = new EntityInsertionAdapter<City>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `city` (`id`,`city_name`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, City value) {
        stmt.bindLong(1, value.id);
        if (value.city == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.city);
        }
      }
    };
    this.__insertionAdapterOfWeather = new EntityInsertionAdapter<Weather>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `weather_tb` (`id`,`city_name`,`country_name`,`temperature`,`humidity`,`pressure`,`record_date`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Weather value) {
        stmt.bindLong(1, value.id);
        if (value.cityname == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.cityname);
        }
        if (value.countryname == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.countryname);
        }
        if (value.temperature == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.temperature);
        }
        if (value.humidity == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.humidity);
        }
        if (value.pressure == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.pressure);
        }
        if (value.recordDate == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.recordDate);
        }
      }
    };
  }

  @Override
  public void insert(final City... city) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCity.insert(city);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertRecord(final Weather... weathers) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWeather.insert(weathers);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<City> getAll() {
    final String _sql = "SELECT * FROM city";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city_name");
      final List<City> _result = new ArrayList<City>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final City _item;
        final String _tmpCity;
        if (_cursor.isNull(_cursorIndexOfCity)) {
          _tmpCity = null;
        } else {
          _tmpCity = _cursor.getString(_cursorIndexOfCity);
        }
        _item = new City(_tmpCity);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Weather> AllRecord() {
    final String _sql = "SELECT * FROM weather_tb";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCityname = CursorUtil.getColumnIndexOrThrow(_cursor, "city_name");
      final int _cursorIndexOfCountryname = CursorUtil.getColumnIndexOrThrow(_cursor, "country_name");
      final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
      final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
      final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
      final int _cursorIndexOfRecordDate = CursorUtil.getColumnIndexOrThrow(_cursor, "record_date");
      final List<Weather> _result = new ArrayList<Weather>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Weather _item;
        final String _tmpCityname;
        if (_cursor.isNull(_cursorIndexOfCityname)) {
          _tmpCityname = null;
        } else {
          _tmpCityname = _cursor.getString(_cursorIndexOfCityname);
        }
        final String _tmpCountryname;
        if (_cursor.isNull(_cursorIndexOfCountryname)) {
          _tmpCountryname = null;
        } else {
          _tmpCountryname = _cursor.getString(_cursorIndexOfCountryname);
        }
        final String _tmpTemperature;
        if (_cursor.isNull(_cursorIndexOfTemperature)) {
          _tmpTemperature = null;
        } else {
          _tmpTemperature = _cursor.getString(_cursorIndexOfTemperature);
        }
        final String _tmpHumidity;
        if (_cursor.isNull(_cursorIndexOfHumidity)) {
          _tmpHumidity = null;
        } else {
          _tmpHumidity = _cursor.getString(_cursorIndexOfHumidity);
        }
        final String _tmpPressure;
        if (_cursor.isNull(_cursorIndexOfPressure)) {
          _tmpPressure = null;
        } else {
          _tmpPressure = _cursor.getString(_cursorIndexOfPressure);
        }
        final String _tmpRecordDate;
        if (_cursor.isNull(_cursorIndexOfRecordDate)) {
          _tmpRecordDate = null;
        } else {
          _tmpRecordDate = _cursor.getString(_cursorIndexOfRecordDate);
        }
        _item = new Weather(_tmpCityname,_tmpCountryname,_tmpTemperature,_tmpHumidity,_tmpPressure,_tmpRecordDate);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<City> findCityWithName(final String cityname) {
    final String _sql = "SELECT * FROM city WHERE city_name=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cityname == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cityname);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city_name");
      final List<City> _result = new ArrayList<City>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final City _item;
        final String _tmpCity;
        if (_cursor.isNull(_cursorIndexOfCity)) {
          _tmpCity = null;
        } else {
          _tmpCity = _cursor.getString(_cursorIndexOfCity);
        }
        _item = new City(_tmpCity);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
