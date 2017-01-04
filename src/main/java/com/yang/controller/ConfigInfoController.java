package com.yang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Usage: <b> </b>
 *
 * @author Jingyi.Yang
 *         Date 2017/1/4
 **/
@RestController
public class ConfigInfoController {
    @Value(("${config.name}"))
    String name = "World";

    @RequestMapping("/name")
    public String home() {
        return "Hello " + name;
    }

}
