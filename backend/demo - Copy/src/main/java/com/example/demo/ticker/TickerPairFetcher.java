package com.example.demo.ticker;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Objects;


@Service
public class TickerPairFetcher {
    static final String url = "https://api.kraken.com/0/public/Ticker?pair=";

    private final RestTemplate restTemplate;

    public TickerPairFetcher(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getTickerValue(String pairName){
        return Objects.requireNonNull(restTemplate.getForObject(url + pairName, String.class)).replaceAll("\"", "");
    }
}

