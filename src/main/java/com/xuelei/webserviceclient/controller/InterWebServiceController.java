package com.xuelei.webserviceclient.controller;

import com.xuelei.webserviceclient.Service.InterWebServiceService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class InterWebServiceController {
    @Resource
    private InterWebServiceService InterWebServiceServiceImpl;
}
