package com.geekbrains.weather.fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import com.geekbrains.weather.R;
import com.geekbrains.weather.SecondActivity;
import com.geekbrains.weather.WeatherFragmentAdapter;

import java.util.Objects;

public class CitiesFragments extends Fragment {

    static final String keyForIndex = "index";
    static final String keyForAirHumidity = "keyForAirHumidity";
    static final String keyForWindSpeed = "keyForWindSpeed";
    static final String keyForPressure = "keyForPressure";

    private ListView listCities;
    private int currentPosition = 0;

    private Bundle savedInstanceState = null;

    private boolean airHumidityFlag;
    private boolean windSpeedFlag;
    private boolean pressureFlag;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
    }

    @Override
    public void onResume() {
        super.onResume();
        init();
    }

    private void initViews(View view) {
        listCities = view.findViewById(R.id.cities_list_view);
    }

    private void init() {
        FragmentActivity fragmentActivity = getActivity();
        String[] cities = getResources().getStringArray(R.array.cities);

        if(fragmentActivity != null){
            WeatherFragmentAdapter adapter = new WeatherFragmentAdapter(fragmentActivity,cities);
            listCities.setAdapter(adapter);
            setClickListener(listCities);

            if (savedInstanceState != null) {
                currentPosition = savedInstanceState.getInt("CurrentCity", 0);
            }

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                listCities.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                listCities.setItemChecked(currentPosition, true);
                showFragment();
            }
        }
    }

    private void showWeather() {
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            showFragment();
        }
        else{
            showActivity();
        }
    }

    private void showFragment(){

        FragmentManager fragmentManager = getFragmentManager();

        if(fragmentManager != null){
            Fragment weatherFragment = getWeatherFragment();

            if(weatherFragment != null){
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.weather, weatherFragment);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.commit();
            }
        }
    }

    private void showActivity(){
        Intent intent = new Intent(getActivity(), SecondActivity.class);
        intent.putExtra(keyForIndex, currentPosition);
        intent.putExtra(keyForAirHumidity, airHumidityFlag);
        intent.putExtra(keyForWindSpeed, windSpeedFlag);
        intent.putExtra(keyForPressure, pressureFlag);
        startActivity(intent);
    }

    private Fragment getWeatherFragment(){
        FragmentManager fragmentManager = getFragmentManager();
        if(fragmentManager != null){
            WeatherFragment fragment = (WeatherFragment) fragmentManager.findFragmentById(R.id.weather);
            if(fragment == null || fragment.getIndex() != currentPosition){
                fragment = WeatherFragment.create(currentPosition, airHumidityFlag, windSpeedFlag, pressureFlag);
            }
            return fragment;
        }
        return null;
    }

    private void setClickListener(ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentPosition = position;
                setCheckBoxFlags();
                showWeather();
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("CurrentCity", currentPosition);
        super.onSaveInstanceState(outState);
    }

    private void setCheckBoxFlags() {

        CheckBox airHumidityCheck = Objects.requireNonNull(getActivity()).findViewById(R.id.air_humidity_check);
        CheckBox windSpeedCheck = Objects.requireNonNull(getActivity()).findViewById(R.id.wind_speed_check);
        CheckBox pressureCheck = Objects.requireNonNull(getActivity()).findViewById(R.id.pressure_check);

        airHumidityFlag = airHumidityCheck.isChecked();
        windSpeedFlag = windSpeedCheck.isChecked();
        pressureFlag = pressureCheck.isChecked();
    }
}
