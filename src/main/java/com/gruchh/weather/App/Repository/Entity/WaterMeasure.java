package com.gruchh.weather.App.Repository.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "WATER_MEASURE")
public class WaterMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "MEASURE_VALUE")
    private Double measurementValue;

    @NotNull
    @Column(name = "MEASURE_DATA")
    private LocalDate measureDate;

    public WaterMeasure() {
    }

    public WaterMeasure(Double measurementValue, LocalDate measureDate) {
        this.measurementValue = measurementValue;
        this.measureDate = measureDate;
    }
}