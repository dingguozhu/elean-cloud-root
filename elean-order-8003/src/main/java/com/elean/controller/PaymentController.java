package com.elean.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author Elean
 * @Date 2021/5/5 23:44
 * @Description
 * @Version 1.0.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    public String serverPort;

    @RequestMapping("/payment/order")
    public String payment() {
        return "Spring-cloud with zookeeper " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
