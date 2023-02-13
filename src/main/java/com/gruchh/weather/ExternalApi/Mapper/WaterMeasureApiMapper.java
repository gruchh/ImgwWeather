package com.gruchh.weather.ExternalApi.Mapper;

import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import com.gruchh.weather.ExternalApi.Entity.WaterMeasureApi;
import org.apache.commons.lang3.math.NumberUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class WaterMeasureApiMapper {
    static ModelMapper modelMapper = new ModelMapper();

    public static WaterMeasure convertApiDataToDb(WaterMeasureApi waterMeasureApi) {

        WaterMeasure waterMeasure = new WaterMeasure();
        waterMeasure.setMeasureContractor("system");
        waterMeasure.setRiverStateMeasure(convertStringToDouble(waterMeasureApi.getStanWody()));
        waterMeasure.setIcePhenomenon(convertStringToDouble(waterMeasureApi.getZjawiskoZarastania()));
        waterMeasure.setOverGrowthPhenomenon(convertStringToDouble(waterMeasureApi.getZjawiskoZarastania()));
        waterMeasure.setRegistrationDate(LocalDate.now());
        waterMeasure.setIdImgwSite(convertStringToLong(waterMeasureApi.getIdStacji()));

        return waterMeasure;
    }

    private static Double convertStringToDouble (String string) {
        if (string == null) {
            return 0.0;
        } else {
            try {
                return Double.parseDouble(string);
            } catch (Exception ex) {
                return 0.0;
            }
        }
    }

    private static Long convertStringToLong (String string) {
        if (string == null) {
            return Long.parseLong("0", 10) ;
        } else {
            try {
                return Long.parseLong(string, 10) ;
            } catch (Exception ex) {
                return Long.parseLong("0", 10) ;
            }
        }
    }

}
