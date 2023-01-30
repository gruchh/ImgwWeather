package com.gruchh.weather.ExternalApi.Service;

import com.gruchh.weather.ExternalApi.Entity.Station;
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

    public List<Station> getStationInfo() {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Station> stationHttpEntity = new HttpEntity<>(new Station());
        ResponseEntity<Station[]> stationExchange = restTemplate.exchange(restUrl, HttpMethod.GET, stationHttpEntity, Station[].class);
        return Arrays.stream(stationExchange.getBody()).toList();
    }

}
