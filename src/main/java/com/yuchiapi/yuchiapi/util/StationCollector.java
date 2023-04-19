package com.yuchiapi.yuchiapi.util;

import com.yuchiapi.fusionSolarClient.FusionSolarClient;
import com.yuchiapi.fusionSolarClient.FusionSolarClientFactory;
import com.yuchiapi.fusionSolarClient.model.response.StationRealKpiList;
import com.yuchiapi.yuchiapi.db.InMemoryDB;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StationCollector {
    private final static String login = "lviv_tech_api_user";
    private final static String pass = "GEnzSQ5fiNT9eKe";
    private final static String stationId = "NE=34915216";
    private final FusionSolarClient fusionSolarClient = FusionSolarClientFactory.createFusionSolarClient();
    @Scheduled(fixedRate = 1000 * 60 * 15)
    public void collectCurrentWeather() {
        StationRealKpiList stationRealKpiList = null;
        try {
            String token = fusionSolarClient.login(login, pass);
            stationRealKpiList = fusionSolarClient.getStationRealKpi(token, stationId);
            System.out.println("Solar power checked with api");
        } catch (Exception e) {
            throw new RuntimeException("Solar data not initialized " + e);
        } finally {
            if (stationRealKpiList != null) {
                InMemoryDB.solar_station_dayKPI = stationRealKpiList.getData().get(0).getDataItemMap();
                InMemoryDB.solar_station_dayKPI.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            }
        }
    }
}
