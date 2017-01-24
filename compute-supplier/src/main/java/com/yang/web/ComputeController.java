package com.yang.web;

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
public class ComputeController {
    @RequestMapping(value = "/add/{add1}/{add2}", method = RequestMethod.GET)
    public String add(@PathVariable Integer add1, @PathVariable Integer add2) {
        return String.valueOf(add1 + add2);
    }
}
