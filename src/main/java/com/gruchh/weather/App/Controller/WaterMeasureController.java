package com.gruchh.weather.App.Controller;

import com.gruchh.weather.App.Controller.DTO.WaterMeasureDto;
import com.gruchh.weather.App.Service.WaterMeasureServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class WaterMeasureController {

    private final WaterMeasureServiceImpl waterMeasureService;

    @GetMapping("/{id}")
    public ResponseEntity<WaterMeasureDto> findWaterMeasureById(@Min(1) @NotNull @PathVariable Long id) {

        WaterMeasureDto waterMeasureDto = waterMeasureService.findById(id);
        return new ResponseEntity<>(waterMeasureDto, HttpStatus.OK);
    }
}
