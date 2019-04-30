package com.geekbrains.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.geekbrains.weather.MainActivity.keyForCityName;
import static com.geekbrains.weather.MainActivity.keyForAirHumidity;
import static com.geekbrains.weather.MainActivity.keyForWindSpeed;
import static com.geekbrains.weather.MainActivity.keyForPressure;


public class SecondActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    private TextView cityName;
    private TextView weatherDegree;
    private TextView airHumidity;
    private TextView windSpeed;
    private TextView pressure;
    private ImageView weatherStatus;
    private RelativeLayout airHumidityLayout;
    private RelativeLayout windSpeedLayout;
    private RelativeLayout pressureLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toast.makeText(getApplicationContext(),"SecondCreate", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "SecondCreate");
        initViews();
        setCityNameFromIntent();
        setAdditionalWeatherData();
        setOnClickTomorrowBtn();
        setOnClickWeekBtn();
        setOnClickUpdateBtn();
    }

    private void initViews() {
        cityName = findViewById(R.id.cityName);
        weatherDegree = findViewById(R.id.weatherDegree);
        weatherStatus = findViewById(R.id.weatherStatus);
        airHumidityLayout = findViewById(R.id.air_humidity);
        windSpeedLayout = findViewById(R.id.wind_speed);
        pressureLayout = findViewById(R.id.pressure);
        airHumidity = findViewById(R.id.air_humidity_data);
        windSpeed = findViewById(R.id.wind_speed_data);
        pressure = findViewById(R.id.pressure_data);
    }

    private void setCityNameFromIntent() {
        String text = getIntent().getStringExtra(keyForCityName);
        cityName.setText(text);
    }

    private void setAdditionalWeatherData() {
        if (getIntent().getBooleanExtra(keyForAirHumidity, false)) {
            airHumidityLayout.setVisibility(View.VISIBLE);
        } else {
            airHumidityLayout.setVisibility(View.GONE);
        }
        if (getIntent().getBooleanExtra(keyForWindSpeed, false)) {
            windSpeedLayout.setVisibility(View.VISIBLE);
        } else {
            windSpeedLayout.setVisibility(View.GONE);
        }
        if (getIntent().getBooleanExtra(keyForPressure, false)) {
            pressureLayout.setVisibility(View.VISIBLE);
        } else {
            pressureLayout.setVisibility(View.GONE);
        }
    }

    private void setOnClickTomorrowBtn() {
        findViewById(R.id.tomorrowBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeWeatherData();
            }
        });
    }

    private void setOnClickWeekBtn() {
        findViewById(R.id.weekBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, WeekWeatherActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setOnClickUpdateBtn() {
        findViewById(R.id.updateBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
    }

    private void changeWeatherData() {
        weatherDegree.setText(R.string.tomorrow_degree);
        weatherStatus.setImageResource(R.drawable.cloudy);
        airHumidity.setText(R.string.tomorrow_air_humidity_data);
        windSpeed.setText(R.string.tomorrow_wind_speed_data);
        pressure.setText(R.string.tomorrow_pressure_data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"SecondStart", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "SecondStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"SecondResume", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "SecondResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"SecondPause", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "SecondPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"SecondRestart", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "SecondRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"SecondStop", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "SecondStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"SecondDestroy", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "SecondDestroy");
    }
}
