package com.gruchh.weather.ExternalApi.Service;

import com.gruchh.weather.App.Repository.Entity.WaterMeasure;
import com.gruchh.weather.ExternalApi.Entity.WaterMeasureApi;
import com.gruchh.weather.ExternalApi.Mapper.WaterMeasureApiMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImgwService {

    private static final String restUrl = "https://danepubliczne.imgw.pl/api/data/hydro/";

    public List<WaterMeasureApi> getStationInfo() {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<WaterMeasureApi> stationHttpEntity = new HttpEntity<>(new WaterMeasureApi());
        ResponseEntity<WaterMeasureApi[]> stationExchange = restTemplate.exchange(restUrl, HttpMethod.GET, stationHttpEntity, WaterMeasureApi[].class);
        return Arrays.stream(stationExchange.getBody()).toList();
    }

    public List<WaterMeasure> synchronizeApiFromIMGW() {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<WaterMeasureApi> stationHttpEntity = new HttpEntity<>(new WaterMeasureApi());

        ResponseEntity<WaterMeasureApi[]> stationExchange = restTemplate.exchange(restUrl, HttpMethod.GET, stationHttpEntity, WaterMeasureApi[].class);

        List<WaterMeasure> collect = Arrays.stream(stationExchange.getBody()).map(n -> WaterMeasureApiMapper.convertApiDataToDb(n)).collect(Collectors.toList());
        return collect;
    }


}
