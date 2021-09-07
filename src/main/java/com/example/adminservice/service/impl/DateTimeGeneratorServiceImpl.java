package com.example.adminservice.service.impl;

import com.example.adminservice.service.DateTimeGeneratorHttpClient;
import com.example.adminservice.service.DateTimeGeneratorService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DateTimeGeneratorServiceImpl implements DateTimeGeneratorService {

    private final DateTimeGeneratorHttpClient dateTimeGeneratorHttpClient;
    private static boolean hasToTrigger = true;

    public DateTimeGeneratorServiceImpl(DateTimeGeneratorHttpClient dateTimeGeneratorHttpClient) {
        this.dateTimeGeneratorHttpClient = dateTimeGeneratorHttpClient;
    }

    @Override
    @Scheduled(cron = "0 * * ? * *")
    public void triggerTime() {
        if (hasToTrigger) {
            System.out.println("######TRIGGERED####");
            dateTimeGeneratorHttpClient.generate();
        }
    }
}
