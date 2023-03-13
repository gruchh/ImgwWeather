package com.gruchh.weather.App.Repository.Entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "MEASUREMENT_DB_UPDATES")
@NoArgsConstructor
@RequiredArgsConstructor
public class MeasurementUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "DATE", nullable = false)
    private LocalDate date;

}
