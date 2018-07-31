package com.rubycorp.es.project_es_demo.model;

import lombok.Data;

/**
 * Created by woohyunjo on 2018-07-31.
 */
@Data
public class Weather extends EsModel{
    private String city;
    private double temperature;
    private String season;
}
