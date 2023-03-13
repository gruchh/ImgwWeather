package com.gruchh.weather.App.Repository.Entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WATER_MEASURE")
public class WaterMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "MEASUREMENT_CONTRACTOR")
    private String measureContractor;

    @NonNull
    @Column(name = "RIVER_STATE_MEASURE")
    private Double riverStateMeasure;

    @NonNull
    @Column(name = "RIVER_ICE_PHENOMENON")
    private Double icePhenomenon;

    @NonNull
    @Column(name = "RIVER_OVERGROWTH_PHENOMENON")
    private Double overGrowthPhenomenon;

    @NonNull
    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @NonNull
    @Column(name = "IMGW_STATION_ID")
    private Long idImgwSite;

}