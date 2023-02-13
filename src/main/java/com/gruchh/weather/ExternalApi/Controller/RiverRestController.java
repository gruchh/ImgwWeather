package com.gruchh.weather.ExternalApi.Controller;

import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import com.gruchh.weather.ExternalApi.Entity.WaterMeasureApi;
import com.gruchh.weather.ExternalApi.Service.ImgwService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rivers")
public class RiverRestController {

    private final ImgwService imgwService;
    public RiverRestController(ImgwService imgwService) {
        this.imgwService = imgwService;
    }

    @GetMapping("/status")
    public List<WaterMeasureApi> getStatus() {
        return imgwService.getStationInfo();
    }

    @GetMapping("/test")
    public List<WaterMeasure> sync() {
        return imgwService.synchronizeApiFromIMGW();
    }


}