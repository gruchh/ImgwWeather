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

    public void addNewMeasure (WaterMeasure waterMeasure) {
        waterMeasureRepository.save(waterMeasure);
    }

    public List<WaterMeasure> getAllWaterMeasures() {
        return waterMeasureRepository.findAll();
    }

    public void saveWaterMeasureList(List<WaterMeasure> waterMeasureList) {
        waterMeasureRepository.saveAll(waterMeasureList);
    }


}
