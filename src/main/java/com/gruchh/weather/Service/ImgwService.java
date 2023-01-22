package com.gruchh.weather.Service;

import com.gruchh.weather.Controller.Dto.StationDTO;
import com.gruchh.weather.Repository.Entity.Station;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ImgwService {

    private static final String restUrl = "https://danepubliczne.imgw.pl/api/data/hydro/";

    public List<StationDTO> getStationInfo() {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Station> stationHttpEntity = new HttpEntity<>(new Station());
        ResponseEntity<Station[]> stationExchange = restTemplate.exchange(restUrl, HttpMethod.GET, stationHttpEntity, Station[].class);

        List<StationDTO> stationDTOList = Stream.of(stationExchange.getBody()).map(station -> new StationDTO(Long.parseLong(station.getIdStacji()),
                station.getStacja(),
                station.getRzeka(),
                station.getStanWody())).collect(Collectors.toList());

        return stationDTOList;



    }


}
