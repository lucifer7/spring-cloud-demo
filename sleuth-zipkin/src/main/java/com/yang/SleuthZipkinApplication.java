package com.yang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
//@EnableBinding
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@ImportAutoConfiguration(FeignAutoConfiguration.class)
public class SleuthZipkinApplication {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
/*
    @Bean
    @ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
    public ZipkinSpanReporter spanCollector() {
        return new ZipkinSpanReporter() {
            @Override
            public void report(Span span) {
                log.info("Reporting span [{}].", span);
            }
        };
    }*/

    /* How often we want to sample log and export to zipkin: always */
    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }

    public static void main(String[] args) {
        SpringApplication.run(SleuthZipkinApplication.class, args);
    }
}

@RestController
@Slf4j
class WebController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${app.url:http://localhost:${local.server.port:${server.port:8080}}}")
    private String url;

    @RequestMapping("/")
    public String home() {
        log.info("Visit home page.");
        return "Hello, sleuth with zipkin.";
    }

    @RequestMapping("/callhome")
    public String callHome() {
        log.info("calling home");
        return restTemplate.getForObject(url, String.class);
    }

}
