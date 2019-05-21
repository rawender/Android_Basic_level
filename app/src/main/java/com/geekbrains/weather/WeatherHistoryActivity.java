package com.geekbrains.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class WeatherHistoryActivity extends AppCompatActivity {

    private String[] tempHistory;
    private TextView cityName;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_history);
        setTempHistory();
        initView();
        setCityName();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        WeatherHistoryAdapter adapter = new WeatherHistoryAdapter(tempHistory);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public int getIndex() {
        int index = 0;
        if (getIntent() != null) {
            index = getIntent().getIntExtra("index", 0);
        }
        return index;
    }

    private void initView() {
        cityName = findViewById(R.id.cityName);
        recyclerView = findViewById(R.id.recyclerView);
    }


    private void setCityName() {
        String[] sityNames = getResources().getStringArray(R.array.cities);
        cityName.setText(sityNames[getIndex()]);
    }

    private void setTempHistory() {
        String[] sityId = getResources().getStringArray(R.array.cities_id);
        switch (sityId[getIndex()]) {
            case "Moscow_id": {
                tempHistory = getResources().getStringArray(R.array.Moscow_id);
                break;
            }
            case "St_Petersburg_id": {
                tempHistory = getResources().getStringArray(R.array.St_Petersburg_id);
                break;
            }
            case "Yekaterinburg_id": {
                tempHistory = getResources().getStringArray(R.array.Yekaterinburg_id);
                break;
            }
            case "Novosibirsk_id": {
                tempHistory = getResources().getStringArray(R.array.Novosibirsk_id);
                break;
            }
            case "Samara_id": {
                tempHistory = getResources().getStringArray(R.array.Samara_id);
                break;
            }
        }
    }
}
