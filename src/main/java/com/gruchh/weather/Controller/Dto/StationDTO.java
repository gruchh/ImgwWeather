package com.gruchh.weather.Controller.Dto;

import javax.validation.constraints.NotBlank;

public record StationDTO(Long id,
                         @NotBlank(message = "Station's name can't be empty")
                         String stationName,
                         @NotBlank(message = "River's name can't be empty")
                         String riverName,
                         @NotBlank (message = "River's name can't be empty")
                         String waterCondition
) {


}
