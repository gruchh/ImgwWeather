package com.gruchh.weather.App.Controller.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class WaterMeasureDto {

    private Long id;
    private String stationName;
    private String riverName;
    private Double riverStateMeasure;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"dd.MM.yyyy"})
    private LocalDate registrationDate;
    private float icePhenomenon;
    private float overGrowthPhenomenon;

}
