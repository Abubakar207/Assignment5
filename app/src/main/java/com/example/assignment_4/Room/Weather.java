package com.example.assignment_4.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "weather_tb")
public class Weather {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "city_name")
    public String cityname;

    @ColumnInfo(name = "country_name")
    public String countryname;

    @ColumnInfo(name = "temperature")
    public String temperature;

    @ColumnInfo(name = "humidity")
    public String humidity;


    @ColumnInfo(name = "pressure")
    public String pressure;

    @ColumnInfo(name = "record_date")
    public String recordDate;

    public Weather(String cityname, String countryname, String temperature, String humidity, String pressure, String recordDate) {
        this.cityname = cityname;
        this.countryname = countryname;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.recordDate = recordDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }
}
