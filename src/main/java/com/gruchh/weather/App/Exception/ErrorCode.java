package com.gruchh.weather.App.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    E001("E001", "MEASURE_NOT_FOUND", 404);

    private final String status;
    private final String message;
    private final Integer statusCode;

}
