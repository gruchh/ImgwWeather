package com.gruchh.weather.App.Scheduler;

import com.gruchh.weather.App.Service.MeasureUpdateService;
import com.gruchh.weather.App.Service.WaterMeasureServiceImpl;
import com.gruchh.weather.ExternalApi.Service.ImgwExtenalApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MeasurementUpdateScheduler {

    private final WaterMeasureServiceImpl waterMeasureService;
    private final MeasureUpdateService measureUpdateService;
    private final ImgwExtenalApiService imgwExtenalApiService;

    @Scheduled(fixedRate=1*60*1000, initialDelay=1*20*1000)
    private void checkMeasurementUpdateDone () {
        if (measureUpdateService.ifTodaysMeasureIsUpdated()) {
            measureUpdateService.saveTodaysUpdateInformation();
            waterMeasureService.saveWaterMeasureList(imgwExtenalApiService.synchronizeApiFromIMGW());
        }
    }




}
