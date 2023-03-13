package com.gruchh.weather.App.Repository;

import com.gruchh.weather.App.Repository.Entity.MeasurementUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MeasurementUpdateRepository extends JpaRepository<MeasurementUpdate, Long> {
    List<MeasurementUpdate> findByDate(LocalDate date);
}
