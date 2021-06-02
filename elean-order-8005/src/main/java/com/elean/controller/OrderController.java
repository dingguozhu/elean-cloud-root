package com.elean.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author Elean
 * @Date 2021/5/7 23:04
 * @Description
 * @Version 1.0.0
 */
@RestController
@Slf4j
public class OrderController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/order")
    public String order() {
        return "spring-cloud with consul" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
