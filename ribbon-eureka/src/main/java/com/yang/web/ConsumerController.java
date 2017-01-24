package com.yang.web;

import com.yang.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ConsumerController {
    final
    ComputeService computeService;

    @Autowired
    public ConsumerController(ComputeService computeService) {
        this.computeService = computeService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return computeService.addService();
    }
}

