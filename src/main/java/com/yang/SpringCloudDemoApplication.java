package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope
@SpringBootApplication      /* Alternation for @Configuration, @EnableAutoConfiguration, @ComponentScan with their defaults */
/*@Configuration
@EnableAutoConfiguration  *//* auto-configuration, designed to work well with Starters *//*
@ComponentScan*/
@EnableDiscoveryClient        /* difference ? */
//@EnableEurekaClient
public class SpringCloudDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoApplication.class, args);
    }
}
