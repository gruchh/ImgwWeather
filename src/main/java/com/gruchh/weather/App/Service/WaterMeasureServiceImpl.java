package com.gruchh.weather.App.Service;

import com.gruchh.weather.App.Controller.DTO.WaterMeasureDto;
import com.gruchh.weather.App.Exception.AppException;
import com.gruchh.weather.App.Exception.ErrorCode;
import com.gruchh.weather.App.Mapper.WaterMeasureMapper;
import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import com.gruchh.weather.App.Repository.WaterMeasureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class WaterMeasureServiceImpl implements WaterMeasureService{

    private final WaterMeasureRepository waterMeasureRepository;

    public List<WaterMeasure> getAllWaterMeasures() {
        return waterMeasureRepository.findAll();
    }

    @Override
    public WaterMeasureDto createMeasure(WaterMeasureDto waterMeasureDto) {
        WaterMeasure waterMeasure = new WaterMeasure(
                waterMeasureDto.getRiverStateMeasure(),
                waterMeasureDto.getIcePhenomenon(),
                waterMeasureDto.getOverGrowthPhenomenon(),
                waterMeasureDto.getRegistrationDate(),
                waterMeasureDto.getIdImgwSite()
        );
        WaterMeasure savedWaterMeasure = waterMeasureRepository.save(waterMeasure);
        return WaterMeasureMapper.mapToWaterMeasureDto(savedWaterMeasure);
    }

    public void saveWaterMeasureList(List<WaterMeasure> waterMeasureList) {
        waterMeasureRepository.saveAll(waterMeasureList);
    }

    @Override
    public WaterMeasureDto findById(@Min(1) @NotNull Long id) {
        Optional<WaterMeasure> waterMeasure = waterMeasureRepository.findById(id);
        return waterMeasure
                .map(WaterMeasureMapper::mapToWaterMeasureDto)
                .orElseThrow(() -> new AppException(
                        ErrorCode.E001,
                        "Record " + id + " has not been found"));
    }

    public List<WaterMeasureDto> getWaterMeasures() {
        return waterMeasureRepository.findAll().stream()
                .map(WaterMeasureMapper::mapToWaterMeasureDto)
                .toList();
    }

    public void deleteMeasureById(@Min(1) @NotNull Long id) {
        if (waterMeasureRepository.existsById(id)) {
            waterMeasureRepository.deleteById(id);
        } else {
            throw new AppException(
                    ErrorCode.E001,
                    "Record " + id + " has not been found");
        }
    }
}
