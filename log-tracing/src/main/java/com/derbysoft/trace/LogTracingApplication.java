package com.derbysoft.trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Usage: <b> </b>
 *
 * @author Jingyi.Yang
 *         Date 2018/1/9
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration(FeignAutoConfiguration.class)
@EnableMBeanExport(defaultDomain = "trivago")
@RestController
public class LogTracingApplication extends SpringBootServletInitializer {

    private static final Logger log = LoggerFactory.getLogger("PERF_LOGGER");

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.OFF)
                .sources(LogTracingApplication.class)
                .run(args);
        log.info("<App start>");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LogTracingApplication.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/")
    public String home() {
        log.info("Visit home page.");
        return "Hello, zipkin.";
    }
}
