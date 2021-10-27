package com.example.adminservice.rest.controllers.impl;

import com.example.adminservice.rest.controllers.AdminServiceController;
import com.example.adminservice.rest.model.Schedule;
import com.example.adminservice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminServiceControllerImpl implements AdminServiceController {

    private final AdminService adminService;

    @Override
    @RequestMapping(value = "/trigger-schedule", method = RequestMethod.POST)
    public ModelAndView changeSchedulingState() {
        ModelAndView modelAndView = new ModelAndView("schedule");
        boolean state = adminService.changeSchedulingState();
        modelAndView.addObject("schedule", new Schedule(state));
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/view-schedule-option", method = RequestMethod.GET)
    public ModelAndView viewSchedulingState() {
        ModelAndView modelAndView = new ModelAndView("schedule");
        modelAndView.addObject("schedule", new Schedule(adminService.getSchedulingState()));
        return modelAndView;
    }
}
