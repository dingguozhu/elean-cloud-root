package com.elean;

import com.yilin.MyIRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author Elean
 * @Date 2021/4/24 21:18
 * @Description
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "elean-order-service", configuration = MyIRule.class)
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
