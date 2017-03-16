package com.yang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@Slf4j
public class SleuthApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/")
    public String home() {
        log.info("Visit home page.");
        return "Hello, sleuth.";
    }

    public static void main(String[] args) {
        SpringApplication.run(SleuthApplication.class, args);
    }
}
