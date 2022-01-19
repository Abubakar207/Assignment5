package com.example.assignment_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WeatherInfo extends AppCompatActivity {
    TextView city ,country ,temp,hum,press;
    Button backbtn ,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);
        city = findViewById(R.id.city);
        country = findViewById(R.id.country);
        temp = findViewById(R.id.temp);
        hum = findViewById(R.id.hum);
        press = findViewById(R.id.press);
        backbtn = findViewById(R.id.back);
        next = findViewById(R.id.more);

        city.setText(getIntent().getStringExtra("City"));
        country.setText(getIntent().getStringExtra("Country"));
        temp.setText(getIntent().getStringExtra("Temp"));
        hum.setText(getIntent().getStringExtra("Hum"));
        press.setText(getIntent().getStringExtra("Pressure"));


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeatherInfo.this,MainActivity.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WeatherInfo.this,TabAct.class);
                startActivity(intent);
            }
        });

    }
}