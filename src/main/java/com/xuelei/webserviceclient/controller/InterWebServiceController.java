package com.xuelei.webserviceclient.controller;

import com.xuelei.webserviceclient.Service.InterWebServiceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class InterWebServiceController {
    @Resource
    private InterWebServiceService interWebServiceService;

    @RequestMapping("/getService")
    public String getWebService(){
        String webService = interWebServiceService.getWebService();
        return webService;
    }

    @RequestMapping("/getApliInfo/{itcode}")
    @ResponseBody
    public String getApliInfo(@PathVariable String itcode){
        return interWebServiceService.getApliInfo(itcode);
    }
}
