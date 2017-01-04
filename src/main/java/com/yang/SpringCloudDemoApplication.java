package com.yang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
@RefreshScope
@Configuration
@EnableAutoConfiguration
@RestController
public class SpringCloudDemoApplication {
    @Value(("${config.name}"))
    String name = "World";

    @RequestMapping("/name")
    public String home() {
        return "Hello " + name;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDemoApplication.class, args);
	}
}
