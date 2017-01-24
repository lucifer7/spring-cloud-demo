package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Usage: <b> </b>
 *
 * @author Jingyi.Yang
 *         Date 2017/1/24
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker       /* Add Hystrix as circuit breaker */
public class RibbonApplication {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }
}
