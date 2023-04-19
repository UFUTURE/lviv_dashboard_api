package com.yuchiapi.yuchiapi.service.impl;

import java.io.IOException;
import java.net.URL;
import com.yuchiapi.yuchiapi.db.InMemoryDB;
import com.yuchiapi.yuchiapi.service.WeatherService;
import com.yuchiapi.yuchiapi.util.DataCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
    private static final String currentWeatherRequest = "https://api.openweathermap.org/data/2.5/weather?lat=49.842957&"
            + "lon=24.031111&appid=57c49127e316b19475e2435341d0d577&units=metric";
    private static final String weeklyWeatherRequest = "https://api.openweathermap.org/data/2.5/forecast?lat=49.842957&"
            + "lon=24.031111&appid=57c49127e316b19475e2435341d0d577&units=metric";

    @Autowired
    private DataCollector dataCollector;

    @Override
    public String getCurrentWeather() {
        return InMemoryDB.currentWeather;
    }

    @Override
    public String getWeeklyWeather() {
        return InMemoryDB.weeklyWeather;
    }

    @Override
    public void collectWeeklyAndSaveToDB() throws IOException {
        InMemoryDB.weeklyWeather = dataCollector.createReport(new URL(weeklyWeatherRequest));
    }

    @Override
    public void collectCurrentAndSaveToDB() throws IOException {
        InMemoryDB.currentWeather = dataCollector.createReport(new URL(currentWeatherRequest));
    }
}
