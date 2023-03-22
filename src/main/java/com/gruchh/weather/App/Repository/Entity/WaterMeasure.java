package com.gruchh.weather.App.Repository.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WATER_MEASURE")
public class WaterMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "RIVER_NAME")
    private String riverName;

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