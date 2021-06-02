package com.elean.controller;

import com.elean.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Elean
 * @Date 2021/5/16 10:25
 * @Description
 * @Version 1.0.0
 */
@RestController
@Slf4j
@RequestMapping("/pay")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/good/{id}")
    public String good(@PathVariable("id") Long id){
        return paymentService.good(id);
    }

    @RequestMapping("/bad/{id}")
    public String bad(@PathVariable("id") Long id) {
        return paymentService.bad(id);
    }

    @GetMapping("/circuit/{id}")
    public String circuitBreaker(@PathVariable("id") Long id) {
        String s = paymentService.paymentCircuitBreaker(id);
        log.info("result:" + s);
        return s;
    }
}
