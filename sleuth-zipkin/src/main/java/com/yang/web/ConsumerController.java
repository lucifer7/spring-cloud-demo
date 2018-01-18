package com.yang.web;

import com.yang.service.ComputeClient;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Usage: <b> Test invocation chain and Span </b>
 *
 * @author Jingyi.Yang
 *         Date 2017/1/24
 **/
@RestController
public class ConsumerController {
    private final ComputeClient computeClient;

    @Autowired
    public ConsumerController(ComputeClient computeClient) {
        this.computeClient = computeClient;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return  computeClient.add(RandomUtils.nextInt(100), RandomUtils.nextInt(100));
    }
}
