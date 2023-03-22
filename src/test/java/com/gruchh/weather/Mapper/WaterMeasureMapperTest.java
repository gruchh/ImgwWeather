package com.gruchh.weather.Mapper;

import com.gruchh.weather.App.Controller.DTO.WaterMeasureDto;
import com.gruchh.weather.App.Mapper.WaterMeasureMapper;
import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WaterMeasureMapperTest {

    @Autowired
    private WaterMeasureMapper waterMeasureMapper;

    @Test
    void testMapToWaterMeasureDto() {
        //given
        WaterMeasure waterMeasure = new WaterMeasure(
                1L,
                "Pszczynka",
                32.2,
                99.2,
                23.1,
                LocalDate.of(2021, 01, 01),
                342L
        );

        WaterMeasureDto waterMeasureDto = new WaterMeasureDto(
                1L,
                "Pszczynka",
                32.2,
                LocalDate.of(2021, 01, 01),
                99.2,
                23.1,
                342L
        );

        //when
        WaterMeasureDto testWaterMeasureDto = waterMeasureMapper.mapToWaterMeasureDto(waterMeasure);

        //then
        assertEquals(waterMeasureDto.getId(), testWaterMeasureDto.getId());
        assertEquals(waterMeasureDto.getRiverStateMeasure(), testWaterMeasureDto.getRiverStateMeasure());
        assertEquals(waterMeasureDto.getRiverName(), testWaterMeasureDto.getRiverName());
        assertEquals(waterMeasureDto.getRegistrationDate(), testWaterMeasureDto.getRegistrationDate());
        assertEquals(waterMeasureDto.getIcePhenomenon(), testWaterMeasureDto.getIcePhenomenon());
        assertEquals(waterMeasureDto.getOverGrowthPhenomenon(), testWaterMeasureDto.getOverGrowthPhenomenon());
        assertEquals(waterMeasureDto.getIdImgwSite(), testWaterMeasureDto.getIdImgwSite());
    }
}
