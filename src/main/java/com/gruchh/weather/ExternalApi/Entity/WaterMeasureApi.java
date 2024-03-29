package com.gruchh.weather.ExternalApi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.HashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id_stacji",
        "stacja",
        "rzeka",
        "wojewodztwo",
        "stan_wody",
        "stan_wody_data_pomiaru",
        "temperatura_wody",
        "temperatura_wody_data_pomiaru",
        "zjawisko_lodowe",
        "zjawisko_lodowe_data_pomiaru",
        "zjawisko_zarastania",
        "zjawisko_zarastania_data_pomiaru"
})

@Generated("jsonschema2pojo")
@Getter
@Setter
public class WaterMeasureApi {

    @JsonProperty("id_stacji")
    private String idStacji;

    @JsonProperty("stacja")
    private String stacja;

    @JsonProperty("rzeka")
    private String rzeka;

    @JsonProperty("województwo")
    private String wojewodztwo;

    @JsonProperty("stan_wody")
    private String stanWody;

    @JsonProperty("stan_wody_data_pomiaru")
    private String stanWodyDataPomiaru;

    @JsonProperty("temperatura_wody")
    private String temperaturaWody;

    @JsonProperty("temperatura_wody_data_pomiaru")
    private String temperaturaWodyDataPomiaru;

    @JsonProperty("zjawisko_lodowe")
    private String zjawiskoLodowe;

    @JsonProperty("zjawisko_lodowe_data_pomiaru")
    private String zjawiskoLodoweDataPomiaru;

    @JsonProperty("zjawisko_zarastania")
    private String zjawiskoZarastania;

    @JsonProperty("zjawisko_zarastania_data_pomiaru")
    private String zjawiskoZarastaniaDataPomiaru;

    @JsonIgnore
    private HashMap<String, Object> additionalProperties = new HashMap<String, Object>();

}
