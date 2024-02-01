package com.example.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PadelCourtRentalClient {

    private static final Logger log = LoggerFactory.getLogger(PadelCourtRentalClient.class);

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<PadelCourt> request = new HttpEntity<>(new PadelCourt("Court3", "Location C", 30));
        restTemplate.postForObject("http://localhost:8080/padel-courts", request, PadelCourt.class);

        List<PadelCourt> padelCourts = restTemplate.getForObject("http://localhost:8080/padel-courts", List.class);
        log.info(padelCourts.toString());
    }
}
