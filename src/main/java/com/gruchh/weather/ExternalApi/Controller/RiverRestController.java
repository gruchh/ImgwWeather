package com.gruchh.weather.ExternalApi.Controller;

import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import com.gruchh.weather.ExternalApi.Entity.WaterMeasureApi;
import com.gruchh.weather.ExternalApi.Service.ImgwExtenalApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rivers")
public class RiverRestController {

    private final ImgwExtenalApiService imgwExtenalApiService;
    public RiverRestController(ImgwExtenalApiService imgwExtenalApiService) {
        this.imgwExtenalApiService = imgwExtenalApiService;
    }

    @GetMapping("/status")
    public List<WaterMeasureApi> getStatus() {
        return imgwExtenalApiService.getStationInfo();
    }

    @GetMapping("/test")
    public List<WaterMeasure> sync() {
        return imgwExtenalApiService.synchronizeApiFromIMGW();
    }


}