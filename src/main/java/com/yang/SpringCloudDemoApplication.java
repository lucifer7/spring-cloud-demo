package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope
@SpringBootApplication      /* Alternation for @Configuration, @EnableAutoConfiguration, @ComponentScan */
/*@Configuration
@EnableAutoConfiguration  *//* auto-configuration, designed to work well with Starters *//*
@ComponentScan*/
public class SpringCloudDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoApplication.class, args);
    }
}
