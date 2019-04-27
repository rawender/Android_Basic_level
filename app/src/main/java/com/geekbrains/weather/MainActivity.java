package com.geekbrains.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    static final String keyForCityName = "keyForCityName";

    private EditText cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"MainCreate", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MainCreate");
        initViews();
        setOnClickCheckBtn();
    }

    private void initViews() {
        cityName = findViewById(R.id.cityName);
    }

    private void setOnClickCheckBtn() {
        findViewById(R.id.checkBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strCityName = cityName.getText().toString();
                if (strCityName.equals("")) {
                    Toast.makeText(getApplicationContext(),"No city specified", Toast.LENGTH_LONG).show();
                    Log.i(TAG, "No city specified");
                } else {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra(keyForCityName,strCityName);
                    startActivity(intent);
                }
            }
        });
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
