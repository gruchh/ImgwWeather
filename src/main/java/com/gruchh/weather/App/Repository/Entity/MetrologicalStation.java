package com.gruchh.weather.App.Repository.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "METROLOGICAL_STATION")
public class MetrologicalStation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String river;

    @Column(nullable = false)
    private String voivodeship;

}
