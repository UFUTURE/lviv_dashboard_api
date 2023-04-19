package com.yuchiapi.yuchiapi.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuchiapi.fusionSolarClient.model.response.DataItemStationRealKpi;
import com.yuchiapi.yuchiapi.db.InMemoryDB;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping("/solar")
public class solarPowerController {

    @JsonFormat
    @GetMapping()
    public DataItemStationRealKpi getSolarKPI() {
        return InMemoryDB.solar_station_dayKPI;
    }
}
