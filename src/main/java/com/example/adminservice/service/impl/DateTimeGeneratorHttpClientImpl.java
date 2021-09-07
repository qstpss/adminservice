package com.example.adminservice.service.impl;

import com.example.adminservice.service.DateTimeGeneratorHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class DateTimeGeneratorHttpClientImpl implements DateTimeGeneratorHttpClient {
    private final RestTemplate restTemplate;
    private final String serviceUrl;

    public DateTimeGeneratorHttpClientImpl(RestTemplate restTemplate,
                                           @Value("${generate-date-time.service.base.url}") String serviceUrl) {
        this.restTemplate = restTemplate;
        this.serviceUrl = serviceUrl;
    }

    @Override
    public void generate() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(serviceUrl);
        uriBuilder.path("/generate/time");
        restTemplate.postForEntity(uriBuilder.build().toUri(), null, Void.class);
    }
}
