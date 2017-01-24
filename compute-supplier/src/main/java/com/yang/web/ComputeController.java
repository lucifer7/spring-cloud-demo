package com.yang.web;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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

    /*@RequestMapping(value = "/add/{add1}/{add2}", method = RequestMethod.GET)
    public String add(@PathVariable Integer add1, @PathVariable Integer add2) {
        ServiceInstance instance = client.getLocalServiceInstance();
        System.out.println("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + add1 + add2);
        return String.valueOf(add1 + add2);
    }*/

    @RequestMapping(value = "/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        System.out.println("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + (a + b));
        return a + b;

    }
}
