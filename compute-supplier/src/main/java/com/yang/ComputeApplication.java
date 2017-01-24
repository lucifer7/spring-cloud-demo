package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Usage: <b> </b>
 *
 * @author Jingyi.Yang
 *         Date 2017/1/24
 **/
@SpringBootApplication
@EnableEurekaClient
public class ComputeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComputeApplication.class, args);
    }
}
