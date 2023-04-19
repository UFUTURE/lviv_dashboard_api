package com.yuchiapi.fusionSolarClient.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public final class DataItemStationRealKpi {

    private String day_power;
    private String month_power;
    private String total_power;
    private String day_income;
    private String total_income;
    private String real_health_state;
    private String updateTime;
}
