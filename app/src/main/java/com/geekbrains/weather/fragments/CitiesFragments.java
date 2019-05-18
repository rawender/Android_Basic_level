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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.geekbrains.weather.R;
import com.geekbrains.weather.SecondActivity;

import java.util.Objects;

public class CitiesFragments extends Fragment {

    static final String keyForIndex = "index";
    static final String keyForAirHumidity = "keyForAirHumidity";
    static final String keyForWindSpeed = "keyForWindSpeed";
    static final String keyForPressure = "keyForPressure";

    private ListView listCities;
    private TextView emptyTextView;
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
        setCheckBoxFlags();
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
        emptyTextView = view.findViewById(R.id.cities_list_empty_view);
    }

    private void init() {
        FragmentActivity fragmentActivity = getActivity();

        if(fragmentActivity != null){
            ArrayAdapter adapter = ArrayAdapter.createFromResource(fragmentActivity,
                    R.array.cities,
                    android.R.layout.simple_list_item_activated_1);
            listCities.setAdapter(adapter);
            listCities.setEmptyView(emptyTextView);
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
        intent.putExtra("index", currentPosition);
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
        Intent bundle = Objects.requireNonNull(getActivity()).getIntent();
        if (bundle != null) {
            airHumidityFlag = bundle.getBooleanExtra(keyForAirHumidity, false);
            windSpeedFlag = bundle.getBooleanExtra(keyForWindSpeed, false);
            pressureFlag = bundle.getBooleanExtra(keyForPressure, false);
        }
    }
}
