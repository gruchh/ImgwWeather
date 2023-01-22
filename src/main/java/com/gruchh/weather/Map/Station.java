package com.gruchh.weather.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.mapping.Map;

import javax.annotation.processing.Generated;
import java.util.HashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id_stacji",
        "stacja",
        "rzeka",
        "wojew\u00f3dztwo",
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
public class Station {

    @JsonProperty("id_stacji")
    private String idStacji;
    @JsonProperty("stacja")
    private String stacja;
    @JsonProperty("rzeka")
    private String rzeka;
    @JsonProperty("wojew\u00f3dztwo")
    private String wojewDztwo;
    @JsonProperty("stan_wody")
    private String stanWody;
    @JsonProperty("stan_wody_data_pomiaru")
    private String stanWodyDataPomiaru;
    @JsonProperty("temperatura_wody")
    private Object temperaturaWody;
    @JsonProperty("temperatura_wody_data_pomiaru")
    private Object temperaturaWodyDataPomiaru;
    @JsonProperty("zjawisko_lodowe")
    private String zjawiskoLodowe;
    @JsonProperty("zjawisko_lodowe_data_pomiaru")
    private String zjawiskoLodoweDataPomiaru;
    @JsonProperty("zjawisko_zarastania")
    private Object zjawiskoZarastania;
    @JsonProperty("zjawisko_zarastania_data_pomiaru")
    private Object zjawiskoZarastaniaDataPomiaru;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
