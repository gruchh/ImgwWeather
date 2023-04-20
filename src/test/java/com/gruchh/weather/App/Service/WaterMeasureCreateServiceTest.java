package com.gruchh.weather.App.Service;

import com.gruchh.weather.App.Controller.DTO.WaterMeasureDto;
import com.gruchh.weather.App.Controller.WaterMeasureController;
import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import com.gruchh.weather.App.Repository.WaterMeasureRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest (
        controllers = WaterMeasureController.class,
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {WaterMeasureRepository.class, WaterMeasureServiceImpl.class})
)
class WaterMeasureCreateServiceTest {

    @MockBean
    private WaterMeasureRepository waterMeasureRepository;
    @Autowired
    private WaterMeasureServiceImpl walletMeasureService;

    @Test
    @DisplayName("Check create water measure")
    void shouldSucessfullyCreateWaterMeasure() {
        //given
        WaterMeasureDto waterMeasureCreatedDto = new WaterMeasureDto(
                1L,
                2.2,
                LocalDate.of(2011, 01, 02),
                3.1,
                41.2,
                "152210170");
        WaterMeasure waterMeasure = new WaterMeasure(
                1L,
                2.2,
                3.1,
                41.2,
                LocalDate.of(2011, 01, 02),
                "152210170"
        );

        //when
        when(waterMeasureRepository.save(any(WaterMeasure.class))).thenReturn(waterMeasure);
        when(waterMeasureRepository.existsById(1L)).thenReturn(true);
        WaterMeasureDto waterReturnedMeasureDto = walletMeasureService.createMeasure(waterMeasureCreatedDto);

        //then
        Assertions.assertEquals(waterMeasure.getId(), waterReturnedMeasureDto.getId());
        Assertions.assertEquals(waterMeasure.getRiverStateMeasure(), waterReturnedMeasureDto.getRiverStateMeasure());
        Assertions.assertEquals(waterMeasure.getRegistrationDate(), waterReturnedMeasureDto.getRegistrationDate());
        Assertions.assertEquals(waterMeasure.getIcePhenomenon(), waterReturnedMeasureDto.getIcePhenomenon());
        Assertions.assertEquals(waterMeasure.getOverGrowthPhenomenon(), waterReturnedMeasureDto.getOverGrowthPhenomenon());
        Assertions.assertEquals(waterMeasure.getIdImgwSite(), waterReturnedMeasureDto.getIdImgwSite());
    }

}