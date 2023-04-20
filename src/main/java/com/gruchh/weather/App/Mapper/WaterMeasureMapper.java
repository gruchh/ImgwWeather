package com.gruchh.weather.App.Mapper;

import com.gruchh.weather.App.Controller.DTO.WaterMeasureDto;
import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import org.springframework.stereotype.Service;

@Service
public class WaterMeasureMapper {

    public static WaterMeasureDto mapToWaterMeasureDto(WaterMeasure waterMeasure) {
        return new WaterMeasureDto(
                waterMeasure.getId(),
                waterMeasure.getRiverStateMeasure(),
                waterMeasure.getRegistrationDate(),
                waterMeasure.getIcePhenomenon(),
                waterMeasure.getOverGrowthPhenomenon(),
                waterMeasure.getIdImgwSite()
        );
    }

    public static WaterMeasure mapToWaterMeasure(WaterMeasureDto waterMeasureDto) {
        return new WaterMeasure(
                waterMeasureDto.getId(),
                waterMeasureDto.getRiverStateMeasure(),
                waterMeasureDto.getIcePhenomenon(),
                waterMeasureDto.getOverGrowthPhenomenon(),
                waterMeasureDto.getRegistrationDate(),
                waterMeasureDto.getIdImgwSite()
        );
    }

}
