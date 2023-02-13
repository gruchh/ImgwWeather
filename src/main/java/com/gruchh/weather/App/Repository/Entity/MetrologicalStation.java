package com.gruchh.weather.App.Repository.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "METROLOGICAL_STATION")
public class MetrologicalStation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "STATION_NAME", nullable = false)
    private String stationName;

    @NotNull
    @Column(name = "RIVER_NAME", nullable = false)
    private String riverName;

    @NotNull
    @Column(name= "STATION_VOIVODESHIP", nullable = false)
    private String voivodeship;

    @NotNull
    @Column(name = "IMGW_STATION_ID")
    private Long idImgwSite;


}
