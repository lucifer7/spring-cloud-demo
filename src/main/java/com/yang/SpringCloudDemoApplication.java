package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@RefreshScope
@SpringBootApplication      /* Alternation for @Configuration, @EnableAutoConfiguration, @ComponentScan with their defaults */
/*@Configuration
@EnableAutoConfiguration  *//* auto-configuration, designed to work well with Starters *//*
@ComponentScan*/
/* in this case, two below are the same */
//@EnableDiscoveryClient        /* in spring-cloud-commons, for eureka, consul, zookeeper */
@EnableEurekaClient         /* in spring-cloud-netflix, for eureka only. And do not use this in @PostConstruct method or @Scheduled, it must by started earliest */
public class SpringCloudDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoApplication.class, args);
    }
}
