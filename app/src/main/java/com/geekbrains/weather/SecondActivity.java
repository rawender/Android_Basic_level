package com.geekbrains.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toast.makeText(getApplicationContext(),"SecondCreate", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "SecondCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"SecondStart", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "SecondCreate");
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
