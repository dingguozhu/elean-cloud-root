package com.elean.service;

import com.elean.service.handler.PaymentServiceHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Elean
 * @Date 2021/5/16 16:15
 * @Description
 * @Version 1.0.0
 */
@Component
@FeignClient(value = "elean-order-service", fallback = PaymentServiceHandler.class)
public interface PaymentService {
    @RequestMapping("/pay/good/{id}")
    String good(@PathVariable("id") Long id);

    @RequestMapping("/pay/bad/{id}")
    String bad(@PathVariable("id") Long id);
}
