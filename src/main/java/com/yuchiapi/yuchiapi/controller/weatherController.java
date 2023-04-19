package com.yuchiapi.yuchiapi.controller;

import com.yuchiapi.yuchiapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin()
@RestController
@RequestMapping("/weather")
public class weatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current")
    public String getCurrentWeather() {
        return weatherService.getCurrentWeather();
    }

    @GetMapping("/week")
    public String getWeeklyWeather() {
        return weatherService.getWeeklyWeather();
    }
}
