package com.elean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author Elean
 * @Date 2021/4/25 23:21
 * @Description
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurakeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurakeApplication.class, args);
    }
}
