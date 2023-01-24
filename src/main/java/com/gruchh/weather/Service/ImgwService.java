package com.gruchh.weather.Service;

import com.gruchh.weather.Repository.Entity.StationPOJO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class ImgwService {

    private static final String restUrl = "https://danepubliczne.imgw.pl/api/data/hydro/";

    public List<StationPOJO> getStationInfo() {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<StationPOJO> stationHttpEntity = new HttpEntity<>(new StationPOJO());
        ResponseEntity<StationPOJO[]> stationExchange = restTemplate.exchange(restUrl, HttpMethod.GET, stationHttpEntity, StationPOJO[].class);
        return Arrays.stream(stationExchange.getBody()).toList();
    }

}
