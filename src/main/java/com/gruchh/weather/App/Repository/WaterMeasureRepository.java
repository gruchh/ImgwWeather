package com.gruchh.weather.App.Repository;

import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterMeasureRepository extends JpaRepository<WaterMeasure, Long> {

}
