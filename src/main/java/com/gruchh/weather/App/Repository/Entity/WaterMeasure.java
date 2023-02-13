package com.gruchh.weather.App.Repository.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WATER_MEASURE")
public class WaterMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "MEASUREMENT_CONTRACTOR")
    private String measureContractor;

    @NotNull
    @Column(name = "RIVER_STATE_MEASURE")
    private Double riverStateMeasure;

    @NotNull
    @Column(name = "RIVER_ICE_PHENOMENON")
    private Double icePhenomenon;

    @NotNull
    @Column(name = "RIVER_OVERGROWTH_PHENOMENON")
    private Double overGrowthPhenomenon;

    @NotNull
    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Column(name = "IMGW_STATION_ID")
    private Long idImgwSite;

}