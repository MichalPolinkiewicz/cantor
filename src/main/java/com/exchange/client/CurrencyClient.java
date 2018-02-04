package com.exchange.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Lenovo on 01.02.2018.
 */
@Component
public class CurrencyClient {

    @Value("${currencies.endpoint}")
    private String currenciesEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseObject getDataFromServer(){
        restTemplate = new RestTemplate();
        return restTemplate.getForObject(currenciesEndpoint, ResponseObject.class);
    }
}
