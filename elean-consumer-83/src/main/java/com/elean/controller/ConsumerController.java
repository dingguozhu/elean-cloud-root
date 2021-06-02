package com.elean.controller;

import com.elean.entities.CommonResult;
import com.elean.entities.Payment;
import com.elean.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Elean
 * @Date 2021/5/13 22:38
 * @Description
 * @Version 1.0.0
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class ConsumerController {
    @Resource
    private PaymentService paymentService;

    @RequestMapping("/pay/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentService.getPayment(id);
    }

    /**
     * openfeign默认等待 1s
     * @return
     */
    @RequestMapping("/timeout")
    public String openfeignTimeout() {
        return paymentService.openfeignTimeout();
    }
}
