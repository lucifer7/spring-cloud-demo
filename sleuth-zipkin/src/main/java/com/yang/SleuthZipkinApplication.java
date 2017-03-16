package com.yang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zipkin.Span;

@SpringBootApplication
@RestController
@Slf4j
public class SleuthZipkinApplication {

    @Bean
    @ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
    public ZipkinSpanReporter spanCollector() {
        return new ZipkinSpanReporter() {
            @Override
            public void report(Span span) {
                log.info("Reporting span [{}].", span);
            }
        };
    }

    /* How often we want to sample log and export to zipkin: always */
    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }

    @RequestMapping("/")
    public String home() {
        log.info("Visit home page.");
        return "Hello, sleuth with zipkin.";
    }

    public static void main(String[] args) {
        SpringApplication.run(SleuthZipkinApplication.class, args);
    }
}
