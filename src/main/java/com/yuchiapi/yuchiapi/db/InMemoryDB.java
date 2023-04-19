package com.yuchiapi.yuchiapi.db;

import com.yuchiapi.fusionSolarClient.model.response.DataItemStationRealKpi;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class InMemoryDB {
    public static String currentWeather = "Data not initialized";
    public static String weeklyWeather = "Data not initialized";
    public static String currency = "Data not initialized";
    public static String prev_currency = "Data not initialized";
    public static String cryptoCurrency = "Data not initialized";
    public static String prev_cryptoCurrency = "Data not initialized";

    public static DataItemStationRealKpi solar_station_dayKPI = new DataItemStationRealKpi();
}
