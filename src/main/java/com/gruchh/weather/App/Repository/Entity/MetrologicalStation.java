package com.gruchh.weather.App.Repository.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "METROLOGICAL_STATION")
public class MetrologicalStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "STATION_NAME")
    private String stationName;

    @Column(name = "RIVER_NAME")
    private String riverName;

    @Column(name= "STATION_VOIVODESHIP")
    private String voivodeship;

    @Column(name = "IMGW_ID_FK")
    private Long idImgwFk;

}
