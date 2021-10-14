package com.example.adminservice.rest.controllers;

import org.springframework.web.servlet.ModelAndView;

public interface AdminServiceController {
    ModelAndView changeSchedulingState();
    ModelAndView viewSchedulingState();
}
