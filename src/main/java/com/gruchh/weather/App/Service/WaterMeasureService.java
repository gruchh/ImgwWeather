package com.gruchh.weather.App.Service;

import com.gruchh.weather.App.Controller.DTO.WaterMeasureDto;
import com.gruchh.weather.App.Repository.Entity.WaterMeasure;

import java.util.List;

public interface WaterMeasureService {

    public WaterMeasureDto createMeasure(WaterMeasureDto waterMeasureDto);
    public void saveWaterMeasureList(List<WaterMeasure> waterMeasureList);
    public WaterMeasureDto findById(Long id);
    public List<WaterMeasureDto> getWaterMeasures();
    public void deleteMeasureById(Long id);

}
