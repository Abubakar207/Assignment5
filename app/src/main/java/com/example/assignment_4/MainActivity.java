package com.example.assignment_4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.assignment_4.Room.AppDatabase;
import com.example.assignment_4.Room.City;
import com.example.assignment_4.Room.DaoClass;
import com.example.assignment_4.Room.Weather;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button SearchBtn;
    EditText CityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CityName = findViewById(R.id.cityName);
        SearchBtn =findViewById(R.id.searchbtn);
        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = CityName.getText().toString();

                if(!"".equals(result)){

                    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                    String url = "https://api.openweathermap.org/data/2.5/weather?q="+result+"&appid=2d1b74f5ad0d95acfc6cf9bf6bdd5687&units=metric";
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                            (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                                @Override
                                public void onResponse(JSONObject response) {
                                   // textView.setText("Response: " + response.toString());
                                    String City = "";
                                    String Country = "Country : ";
                                    String Pressure = "Pressure : ";
                                    String Humidity = "Humidity : ";
                                    String Temp = "Temp : ";
                                      AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                                      AppDatabase.class, "Weather").allowMainThreadQueries().fallbackToDestructiveMigration().build();

                                    try {
                                        City = response.getString("name");
                                        Country +=response.getJSONObject("sys").getString("country");
                                        Pressure +=response.getJSONObject("main").getString("pressure");
                                        Temp +=response.getJSONObject("main").getString("temp");
                                        Humidity +=response.getJSONObject("main").getString("humidity");
                                        Intent intent = new Intent(MainActivity.this,WeatherInfo.class);
                                        intent.putExtra("Country",Country);
                                        intent.putExtra("City",City);
                                        intent.putExtra("Pressure",Pressure);
                                        intent.putExtra("Temp",Temp);
                                        intent.putExtra("Hum",Humidity);
                                        DaoClass cityDao = db.daoClass();
                                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                        Date date = new Date();
                                        cityDao.insertRecord(new Weather(City,Country,Temp,Humidity,Pressure,formatter.format(date)));
                                        List<City> city = cityDao.findCityWithName(result);
                                        if (city.size() <= 0) {
                                            cityDao.insert(new City(result));
                                        }
                                        startActivity(intent);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                }
                            }, new Response.ErrorListener() {

                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    new AlertDialog.Builder(MainActivity.this)
                                            .setTitle("Alert")
                                            .setMessage("No City Found With This Name")
                                            .setCancelable(true)
                                            .show();

                                }
                            });
                    queue.add(jsonObjectRequest);

                }else
                {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Filed Required")
                            .setMessage("Please Enter City Name")
                            .setCancelable(true)
                            .show();
                }

            }
        });
    }
}