package com.gruchh.weather.Controller;

import com.gruchh.weather.Service.ImgwService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rivers")
public class RiverController {

    private final ImgwService imgwService;

    public RiverController(ImgwService imgwService) {
        this.imgwService = imgwService;
    }

    @GetMapping("/status")
    public String getRiverStatus(Model model) {
        return "aaa";
    }
}
