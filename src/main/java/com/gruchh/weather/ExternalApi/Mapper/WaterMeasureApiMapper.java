package com.gruchh.weather.ExternalApi.Mapper;

import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import com.gruchh.weather.ExternalApi.Entity.WaterMeasureApi;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.gruchh.weather.ExternalApi.Utils.ConversionUtils.convertStringToDouble;
import static com.gruchh.weather.ExternalApi.Utils.ConversionUtils.convertStringToLong;

@Component
public class WaterMeasureApiMapper {

    public static WaterMeasure mapWaterMeasureApiToWaterMeasure(WaterMeasureApi waterMeasureApi) {

        return new WaterMeasure(
                waterMeasureApi.getRzeka(),
                convertStringToDouble(waterMeasureApi.getStanWody()),
                convertStringToDouble(waterMeasureApi.getZjawiskoLodowe()),
                convertStringToDouble(waterMeasureApi.getZjawiskoZarastania()),
                LocalDate.now(),
                convertStringToLong(waterMeasureApi.getIdStacji())
        );
    }



}
