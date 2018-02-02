package com.exchange.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Lenovo on 01.02.2018.
 */
@Component
public class CurrencyClient {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseObject getDataFromServer(){
        restTemplate = new RestTemplate();
        ResponseObject responseObject = restTemplate.getForObject("http://webtask.future-processing.com:8068/currencies", ResponseObject.class);
        return responseObject;
    }
}
