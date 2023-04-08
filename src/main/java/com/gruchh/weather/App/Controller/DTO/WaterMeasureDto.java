package com.gruchh.weather.App.Controller.DTO;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class WaterMeasureDto {

    private Long id;
    private Double riverStateMeasure;
    private LocalDate registrationDate;
    private Double icePhenomenon;
    private Double overGrowthPhenomenon;
    private String idImgwSite;

}
