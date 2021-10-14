package com.example.adminservice.service.impl;

import com.example.adminservice.service.DateTimeGeneratorHttpClient;
import com.example.adminservice.service.DateTimeGeneratorService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DateTimeGeneratorServiceImpl implements DateTimeGeneratorService {

    private final DateTimeGeneratorHttpClient dateTimeGeneratorHttpClient;
    public static boolean hasToTrigger = true;

    public DateTimeGeneratorServiceImpl(DateTimeGeneratorHttpClient dateTimeGeneratorHttpClient) {
        this.dateTimeGeneratorHttpClient = dateTimeGeneratorHttpClient;
    }

    @Override
    @Scheduled(cron = "0/5 * * * * ?")
    public void triggerTime() {
        if (hasToTrigger) {
            System.out.println("######TRIGGERED####");
            dateTimeGeneratorHttpClient.generate();
        }
    }

    @Override
    public boolean changeSchedulingState() {
        hasToTrigger = !hasToTrigger;
        return hasToTrigger;
    }

    @Override
    public boolean getSchedulingState() {
        return hasToTrigger;
    }
}
