package com.yang.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
//@EnableDiscoveryClient
@Slf4j
public class EurekaApplication {
    @Value("${message.state}")
    private static String state;

    public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
        //SpringApplication.run(EurekaApplication.class, args);
        log.info("State from Config Server: {}", state);
    }
}
