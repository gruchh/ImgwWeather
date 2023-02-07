package com.gruchh.weather.App.Service;

import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import com.gruchh.weather.App.Repository.WaterMeasureRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class WaterMeasureService {

    private final WaterMeasureRepository waterMeasureRepository;

    public WaterMeasureService(WaterMeasureRepository waterMeasureRepository) {
        this.waterMeasureRepository = waterMeasureRepository;

    }

    @EventListener(ApplicationReadyEvent.class)
    public void prepareSampleMeasures() {
        WaterMeasure measure1 = new WaterMeasure(23.12, LocalDate.of(2023, 02, 02));
        WaterMeasure measure2 = new WaterMeasure(123.1, LocalDate.of(2023, 02, 5));
        waterMeasureRepository.saveAll(Arrays.asList(measure1, measure2));
    }

    public void saveNewMeasure(WaterMeasure waterMeasure) {
        waterMeasureRepository.save(waterMeasure);
    }

    public List<WaterMeasure> getAllWaterMeasures () {
        return waterMeasureRepository.findAll();
    }


}
