package com.geekbrains.weather.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.geekbrains.weather.R;

public class WeatherFragment extends Fragment {

    private TextView cityName;
    private ImageView weatherStatus;
    private TextView temperature;

    public static WeatherFragment create(int index) {
        WeatherFragment f = new WeatherFragment();

        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    public int getIndex() {
        int index = getArguments().getInt("index", 0);
        return index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.weather_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setCityName();
        setImgWeatherStatus();
        setWeatherTemp();
    }

    private void initViews(View view) {
        cityName = view.findViewById(R.id.cityName);
        weatherStatus = view.findViewById(R.id.weatherStatus);
        temperature = view.findViewById(R.id.weatherDegree);
    }

    private void setCityName() {
        String[] sityNames = getResources().getStringArray(R.array.cities);
        cityName.setText(sityNames[getIndex()]);
    }

    private void setImgWeatherStatus() {
        TypedArray imgs = getResources().obtainTypedArray(R.array.weather_imgs);
        weatherStatus.setImageResource(imgs.getResourceId(getIndex(), -1));
    }

    private void setWeatherTemp() {
        String[] temp = getResources().getStringArray(R.array.temp);
        temperature.setText(temp[getIndex()]);
    }
}

