package com.gruchh.weather.App.Exception;

public class AppException extends RuntimeException {

    private final String businessStatus;
    private final String businessMessage;
    private final String description;
    private final Integer statusCode;

    public AppException(ErrorCode error, String description) {
        super(error.getMessage());
        this.businessStatus = error.getStatus();
        this.businessMessage = error.getMessage();
        this.statusCode = error.getStatusCode();
        this.description = description;
    }



}
