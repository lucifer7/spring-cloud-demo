package com.yang.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Usage: <b> </b>
 *
 * @author Jingyi.Yang
 *         Date 2017/1/24
 **/
@RestController
//@Log4j
public class ComputeController {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add/{add1}/{add2}", method = RequestMethod.GET)
    public String add(@PathVariable Integer add1, @PathVariable Integer add2) {
        ServiceInstance instance = client.getLocalServiceInstance();
        System.out.println("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + add1 + add2);
        return String.valueOf(add1 + add2);
    }
}
