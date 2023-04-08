package com.gruchh.weather.App.Mapper;

import com.gruchh.weather.App.Controller.DTO.WaterMeasureDto;
import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WaterMeasureMapper {

    public WaterMeasureDto mapToWaterMeasureDto(WaterMeasure waterMeasure) {
        return new WaterMeasureDto(
                waterMeasure.getId(),
                waterMeasure.getRiverStateMeasure(),
                waterMeasure.getRegistrationDate(),
                waterMeasure.getIcePhenomenon(),
                waterMeasure.getOverGrowthPhenomenon(),
                waterMeasure.getIdImgwSite()
        );
    }

    public WaterMeasure mapToWaterMeasure(WaterMeasureDto waterMeasureDto) {
        return new WaterMeasure(
                waterMeasureDto.getId(),
                waterMeasureDto.getRiverStateMeasure(),
                waterMeasureDto.getIcePhenomenon(),
                waterMeasureDto.getOverGrowthPhenomenon(),
                waterMeasureDto.getRegistrationDate(),
                waterMeasureDto.getIdImgwSite()
        );
    }

    public List<WaterMeasureDto> mapToWaterMeasureDtoList(final List<WaterMeasure> waterMeasureList) {
        return waterMeasureList.stream()
                .map(this::mapToWaterMeasureDto)
                .collect(Collectors.toList());
    }

}
