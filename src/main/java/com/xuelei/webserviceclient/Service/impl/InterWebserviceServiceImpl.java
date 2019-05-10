package com.xuelei.webserviceclient.Service.impl;

import com.xuelei.webserviceclient.Service.InterWebServiceService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InterWebserviceServiceImpl implements InterWebServiceService {
    @Override
    public String getWebService() {
        String address = "http://127.0.0.1:8000/ws?wsdl";
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient(address);
        Object[] hello = null;
        Map<String,String> map = new HashMap<>();
        try {
            hello = client.invoke("hello", map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hello[0].toString();
    }

    @Override
    public String getApliInfo(String itcode) {
        String address = "http://dcoa3.digitalchina.com/Application/DFAppBackTraceCenter.nsf/wsForTravelBeforeDch?OpenWebService?wsdl";
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient(address);
        Object[] apliInfo = null;
        try {
            apliInfo = client.invoke("GETAPLINFO", itcode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apliInfo[0].toString();
    }
}
