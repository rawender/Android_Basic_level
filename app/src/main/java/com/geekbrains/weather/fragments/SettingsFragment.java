package com.geekbrains.weather.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.geekbrains.weather.R;

import static com.geekbrains.weather.fragments.CitiesFragments.keyForAirHumidity;
import static com.geekbrains.weather.fragments.CitiesFragments.keyForPressure;
import static com.geekbrains.weather.fragments.CitiesFragments.keyForWindSpeed;

public class SettingsFragment extends Fragment{

    private CheckBox airHumidityCheck;
    private CheckBox windSpeedCheck;
    private CheckBox pressureCheck;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

        boolean airHumidityFlag = airHumidityCheck.isChecked();
        boolean windSpeedFlag = windSpeedCheck.isChecked();
        boolean pressureFlag = pressureCheck.isChecked();

        Bundle bundle = new Bundle();
        bundle.putBoolean(keyForAirHumidity, airHumidityFlag);
        bundle.putBoolean(keyForWindSpeed, windSpeedFlag);
        bundle.putBoolean(keyForPressure, pressureFlag);
        Intent intent = getActivity().getIntent();
        intent.putExtras(bundle);
    }

    private void initViews(View view) {
        airHumidityCheck = view.findViewById(R.id.air_humidity_check);
        windSpeedCheck = view.findViewById(R.id.wind_speed_check);
        pressureCheck = view.findViewById(R.id.pressure_check);
    }
}
