package com.example.assignment_4.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface DaoClass {
    @Insert
    void insert(City... city);
    @Insert
    void insertRecord(Weather... weathers);

    @Query("SELECT * FROM city")
    List<City> getAll();

    @Query("SELECT * FROM weather_tb")
    List<Weather> AllRecord();

    @Query("SELECT * FROM city WHERE city_name=:cityname")
    List<City> findCityWithName(String cityname);
}
