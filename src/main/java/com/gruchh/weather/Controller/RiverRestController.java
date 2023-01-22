package com.gruchh.weather.Controller;

import com.gruchh.weather.Service.ImgwService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rivers")
public class RiverRestController {

    private final ImgwService imgwService;

    public RiverRestController(ImgwService imgwService) {
        this.imgwService = imgwService;
    }

    @GetMapping("/status")
    public String getStatus() {

        return "aaa";
    }
}