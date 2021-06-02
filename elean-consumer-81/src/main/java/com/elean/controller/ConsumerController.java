package com.elean.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Elean
 * @Date 2021/5/6 23:54
 * @Description
 * @Version 1.0.0
 */
@RestController
@Slf4j
public class ConsumerController {
    public static final String INVOKE_URL = "http://elean-order-service";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/order")
    public String pay() {
        String template = restTemplate.getForObject(INVOKE_URL + "/payment/order", String.class);
        return template;
    }
}
