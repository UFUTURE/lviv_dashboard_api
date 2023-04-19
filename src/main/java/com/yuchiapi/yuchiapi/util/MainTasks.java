package com.yuchiapi.yuchiapi.util;

import java.io.IOException;

import com.yuchiapi.yuchiapi.db.InMemoryDB;
import com.yuchiapi.yuchiapi.service.CurrencyService;
import com.yuchiapi.yuchiapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MainTasks {
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private CurrencyService currencyService;

    @Scheduled(fixedRate = 1000 * 60 * 60)
    public void collectCurrentWeather() {
        try {
            weatherService.collectCurrentAndSaveToDB();
            System.out.println("Current weather checked with api");
        } catch (IOException e) {
            throw new RuntimeException("Unable to collect hourly weather from API " + e);
        }
    }

    @Scheduled(fixedRate = 1000 * 60 * 60 * 4)
    public void collectCurrency() {
        try {
            if (currencyService.getPrevCryptoCurrency().equals("Data not initialized")
                    && currencyService.getPrevCurrency().equals("Data not initialized")) {
                currencyService.collectCurrencyAndSaveToDB();
                currencyService.collectCryptoCurrencyAndSaveToDB();
                InMemoryDB.prev_currency = currencyService.getCurrency();
                InMemoryDB.prev_cryptoCurrency = currencyService.getCryptoCurrency();
                System.out.println("Currency first init ");
            } else {
                InMemoryDB.prev_currency = currencyService.getCurrency();
                InMemoryDB.prev_cryptoCurrency = currencyService.getCryptoCurrency();
                currencyService.collectCurrencyAndSaveToDB();
                currencyService.collectCryptoCurrencyAndSaveToDB();
                System.out.println("Currency save previous data and update current");
            }
            System.out.println("Currency checked with api");
        } catch (IOException e) {
            throw new RuntimeException("Unable to collect in 4 hour currency from API " + e);
        }
    }

    @Scheduled(fixedRate = 1000 * 60 * 60 * 23)
    public void collectWeeklyWeather() {
        try {
            weatherService.collectWeeklyAndSaveToDB();
            System.out.println("Weekly weather checked with api");
        } catch (IOException e) {
            throw new RuntimeException("Unable to collect daily weather from API " + e);
        }
    }
}
