package com.yang.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Usage: <b> </b>
 *
 * @author Jingyi.Yang
 *         Date 2017/1/24
 **/
@Service
public class ComputeService {
    @Autowired
    RestTemplate restTemplate;

    /* When failed to request, fallbackMethod will be executed, but seemingly Hybrix didn't trip the following requests? */
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        Integer a = RandomUtils.nextInt(100);
        Integer b = RandomUtils.nextInt(100);
        return restTemplate.getForEntity("http://COMPUTE-SUPPLIER/add?a=" + a + "&b=" + b, String.class).getBody();
    }

    public String addServiceFallback() {
        return "error occurred while requesting remote.";
    }
}
