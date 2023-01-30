package com.gruchh.weather.ExternalApi.Controller;

import com.gruchh.weather.ExternalApi.Entity.Station;
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
    public List<Station> getStatus() {
        return imgwService.getStationInfo();
    }


}