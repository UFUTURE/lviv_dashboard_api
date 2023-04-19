package com.yuchiapi.yuchiapi.service;

import java.io.IOException;

public interface WeatherService {
    String getCurrentWeather();

    String getWeeklyWeather();

    void collectWeeklyAndSaveToDB() throws IOException;

    void collectCurrentAndSaveToDB() throws IOException;
}
