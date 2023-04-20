package com.gruchh.weather.App.Controller;

import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import com.gruchh.weather.App.Service.WaterMeasureServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final WaterMeasureServiceImpl waterMeasureService;

    public TestController(WaterMeasureServiceImpl waterMeasureService) {
        this.waterMeasureService = waterMeasureService;
    }

    @GetMapping("/hello")
    public String getSampleResponse() {
        System.out.println("Hello");
        return "hello";
    }

    @GetMapping("/getSampleWaterMeasures")
    public List<WaterMeasure> getSampleWaterMeasures() {
        return waterMeasureService.getAllWaterMeasures();
    }
}
