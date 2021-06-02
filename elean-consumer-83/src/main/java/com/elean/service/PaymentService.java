package com.elean.service;

import com.elean.entities.CommonResult;
import com.elean.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

/**
 * @Author Elean
 * @Date 2021/5/13 22:33
 * @Description
 * @Version 1.0.0
 */
@Component
@FeignClient("elean-order-service")
public interface PaymentService {
    @RequestMapping("/order/payment/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id);

    @RequestMapping("/order/timeout")
    public String openfeignTimeout();
}
