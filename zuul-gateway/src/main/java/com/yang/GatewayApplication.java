package com.yang;

import com.yang.filter.pre.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Usage: <b> </b>
 *
 * @author Jingyi.Yang
 *         Date 2017/2/17
 **/
@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {
    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
