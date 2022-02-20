package com.icemelon404.community.feed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
       SpringApplication app =  new SpringApplication(Application.class);
       app.run(args);
    }
}
