package com.gruchh.weather.App.Repository.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MEASUREMENT_DB_UPDATES")
public class MeasurementUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "DATE", nullable = false)
    private LocalDate date;

}
