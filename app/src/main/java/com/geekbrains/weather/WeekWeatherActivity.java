package com.geekbrains.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class WeekWeatherActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_weather);
        Toast.makeText(getApplicationContext(),"WeekWeatherCreate", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "WeekWeatherCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"WeekWeatherStart", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "WeekWeatherStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"WeekWeatherResume", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "WeekWeatherResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"WeekWeatherPause", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "WeekWeatherPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"WeekWeatherRestart", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "WeekWeatherRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"WeekWeatherStop", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "WeekWeatherStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"WeekWeatherDestroy", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "WeekWeatherDestroy");
    }
}
