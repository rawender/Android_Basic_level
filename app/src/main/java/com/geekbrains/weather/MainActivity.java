package com.geekbrains.weather;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    private TextView weatherDegree;
    private ImageView weatherStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"MainCreate", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MainCreate");
        findViewById(R.id.tomorrowBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initViews();
                changeText();
                changeImage();
            }
        });
        findViewById(R.id.weekBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.updateBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
    }

    private void initViews() {
        weatherDegree = findViewById(R.id.weatherDegree);
        weatherStatus = findViewById(R.id.weatherStatus);
    }

    private void changeText() {
        weatherDegree.setText(getString(R.string.tomorrow_degree));
    }

    private void changeImage() {
        weatherStatus.setImageResource(R.drawable.cloudy);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"MainStart", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MainStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"MainResume", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MainResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"MainPause", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MainPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"MainRestart", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MainRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"MainStop", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MainStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"MainDestroy", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MainDestroy");
    }
}
