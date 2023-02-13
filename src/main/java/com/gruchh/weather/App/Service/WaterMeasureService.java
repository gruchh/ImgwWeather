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
        WaterMeasure measure1 = new WaterMeasure(1L, "Pomiarowiec", 2.0, 3.0, 3.2, LocalDate.now(), 21L);
        WaterMeasure measure2 = new WaterMeasure(2L, "System", 2.330, 987.1, 3.11, LocalDate.now(), 3421L);
        waterMeasureRepository.saveAll(Arrays.asList(measure1, measure2));
    }

    public void saveNewMeasure(WaterMeasure waterMeasure) {
        waterMeasureRepository.save(waterMeasure);
    }

    public List<WaterMeasure> getAllWaterMeasures() {
        return waterMeasureRepository.findAll();
    }


}
