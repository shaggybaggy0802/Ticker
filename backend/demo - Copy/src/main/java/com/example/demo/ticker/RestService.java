package com.example.demo.ticker;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    //za public rest api krakena
    private final RestTemplate restTemplate;

    /**
     *
     * @param restTemplateBuilder
     */
    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     *
     * @param url
     * @return
     */
    public String getTickerData(String url) {
        return this.restTemplate.getForObject(url, String.class);
    }

}