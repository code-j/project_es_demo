package com.rubycorp.es.project_es_demo;

import com.rubycorp.es.project_es_demo.api.ElasticSearchApi;
import com.rubycorp.es.project_es_demo.model.Weather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectEsDemoApplicationTests {

    @Autowired
    ElasticSearchApi elasticSearchApi;

    private final String ELASTIC_INDEX = "test_index";
    private final String ELASTIC_TYPE = "test_type";

    @Test
    public void 엘라스틱서치_POST_전송() {
        String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE;
        Weather weather = new Weather();
        weather.setCity("Seoul");
        weather.setTemperature(10.2);
        weather.setSeason("Winter");

        Map<String, Object> result = elasticSearchApi.callElasticApi("POST", url, weather, null);
        System.out.println(result.get("resultCode"));
        System.out.println(result.get("resultBody"));
    }

    @Test
    public void 엘라스틱서치_PUT_전송() {
        String id = "122345";
        String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE + "/" + id;
        Weather weather = new Weather();
        weather.setCity("Tokyo");
        weather.setTemperature(12.3);
        weather.setSeason("Winter");

        Map<String, Object> result = elasticSearchApi.callElasticApi("PUT", url, weather, null);
        System.out.println(result.get("resultCode"));
        System.out.println(result.get("resultBody"));
    }

    @Test
    public void 앨라스틱서치_GET_전송() {
        String id = "122345";
        String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE + "/" + id;
        Map<String, Object> result = elasticSearchApi.callElasticApi("GET", url, null, null);
        System.out.println(result.get("resultCode"));
        System.out.println(result.get("resultBody"));
    }

    @Test
    public void 앨라스틱서치_DELETE_전송() {
        String id = "122345";
        String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE + "/" + id;
        Map<String, Object> result = elasticSearchApi.callElasticApi("DELETE", url, null, null);
        System.out.println(result.get("resultCode"));
        System.out.println(result.get("resultBody"));
    }
}