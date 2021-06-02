package com.elean.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Elean
 * @Date 2021/5/9 16:37
 * @Description
 * @Version 1.0.0
 */
@RestController
@Slf4j
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;
    private static final String BALANCE_URL = "http://elean-order-service";

    @RequestMapping("/consumer/pay")
    public String pay() {
        return restTemplate.getForObject(BALANCE_URL + "/payment/order", String.class);
    }
}
