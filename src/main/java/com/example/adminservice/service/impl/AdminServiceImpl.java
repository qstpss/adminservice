package com.example.adminservice.service.impl;

import com.example.adminservice.service.AdminService;
import com.example.adminservice.service.DateTimeGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final DateTimeGeneratorService dateTimeGeneratorService;

    @Override
    public boolean changeSchedulingState() {
        return dateTimeGeneratorService.changeSchedulingState();
    }

    @Override
    public boolean getSchedulingState() {
        return dateTimeGeneratorService.getSchedulingState();
    }
}
