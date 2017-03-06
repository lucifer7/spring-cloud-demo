package com.yang;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Usage: <b> </b>
 *
 * @author Jingyi.Yang
 *         Date 2017/1/24
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ComputeApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ComputeApplication.class).web(true).run(args);
    }
}
