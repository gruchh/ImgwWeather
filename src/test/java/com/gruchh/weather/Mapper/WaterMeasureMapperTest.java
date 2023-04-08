package com.gruchh.weather.Mapper;

import com.gruchh.weather.App.Controller.DTO.WaterMeasureDto;
import com.gruchh.weather.App.Mapper.WaterMeasureMapper;
import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WaterMeasureMapperTest {

    @Autowired
    private WaterMeasureMapper waterMeasureMapper;

    WaterMeasure waterMeasure1;
    WaterMeasure waterMeasure2;
    WaterMeasureDto waterMeasureDto1;
    WaterMeasureDto waterMeasureDto2;


    private void prepareTestData() {
        //given
        waterMeasure1 = new WaterMeasure(
                1L,
                "Pszczynka",
                32.2,
                99.2,
                23.1,
                LocalDate.of(2021, 01, 01),
                342L
        );

        waterMeasureDto1 = new WaterMeasureDto(
                1L,
                "Pszczynka",
                32.2,
                LocalDate.of(2021, 01, 01),
                99.2,
                23.1,
                342L
        );

        waterMeasure2 = new WaterMeasure(
                2L,
                "Wisła",
                6532.2,
                939.2,
                223.1,
                LocalDate.of(2009, 04, 01),
                765L
        );
        waterMeasureDto2 = new WaterMeasureDto(
                2L,
                "Wisła",
                6532.2,
                LocalDate.of(2009, 04, 01),
                939.2,
                223.1,
                765L
        );
    }

    @Test
    void testMapToWaterMeasureDto() {
        //given
        prepareTestData();

        //when
        WaterMeasureDto testWaterMeasureDto = waterMeasureMapper.mapToWaterMeasureDto(waterMeasure1);

        //then
        assertEquals(waterMeasureDto1.getId(), testWaterMeasureDto.getId());
        assertEquals(waterMeasureDto1.getRiverStateMeasure(), testWaterMeasureDto.getRiverStateMeasure());
        assertEquals(waterMeasureDto1.getRiverName(), testWaterMeasureDto.getRiverName());
        assertEquals(waterMeasureDto1.getRegistrationDate(), testWaterMeasureDto.getRegistrationDate());
        assertEquals(waterMeasureDto1.getIcePhenomenon(), testWaterMeasureDto.getIcePhenomenon());
        assertEquals(waterMeasureDto1.getOverGrowthPhenomenon(), testWaterMeasureDto.getOverGrowthPhenomenon());
        assertEquals(waterMeasureDto1.getIdImgwSite(), testWaterMeasureDto.getIdImgwSite());
    }

    @Test
    void testMapToWaterMeasure() {

        //given
        prepareTestData();

        //when
        WaterMeasure testWaterMeasure = waterMeasureMapper.mapToWaterMeasure(waterMeasureDto1);

        //then
        assertEquals(waterMeasure1.getId(), testWaterMeasure.getId());
        assertEquals(waterMeasure1.getRiverStateMeasure(), testWaterMeasure.getRiverStateMeasure());
        assertEquals(waterMeasure1.getRegistrationDate(), testWaterMeasure.getRegistrationDate());
        assertEquals(waterMeasure1.getIcePhenomenon(), testWaterMeasure.getIcePhenomenon());
        assertEquals(waterMeasure1.getRiverName(), testWaterMeasure.getRiverName());
        assertEquals(waterMeasure1.getOverGrowthPhenomenon(), testWaterMeasure.getOverGrowthPhenomenon());
        assertEquals(waterMeasure1.getIdImgwSite(), testWaterMeasure.getIdImgwSite());
    }


    @Test
    void testMapToTaskDtoList() {
//        //Given
        prepareTestData();

        List<WaterMeasure> waterMeasureList = new ArrayList<>();
        waterMeasureList.add(waterMeasure1);
        waterMeasureList.add(waterMeasure2);

        List<WaterMeasureDto> waterMeasureDtoList = new ArrayList<>();
        waterMeasureDtoList.add(waterMeasureDto1);
        waterMeasureDtoList.add(waterMeasureDto2);

        //When
        List<WaterMeasureDto> testList = waterMeasureMapper.mapToWaterMeasureDtoList(waterMeasureList);

//        //Then
        assertEquals(waterMeasureDtoList.get(0).getId(), testList.get(0).getId());

        assertEquals(waterMeasureDtoList.get(1).getId(), testList.get(1).getId());

    }
}
