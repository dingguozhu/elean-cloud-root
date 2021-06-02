package com.elean.controller;

import com.elean.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Elean
 * @Date 2021/5/16 16:25
 * @Description
 * @Version 1.0.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "errorGlobalHandler") //全局配置Hystrix降级处理方式二 处理超时或者异常
@RequestMapping("/consumer")
public class ConsumerController {
    @Resource
    private PaymentService paymentService;
    @RequestMapping("/good/{id}")
    public String good(@PathVariable("id") Long id) {
        return paymentService.good(id);
    }

//    @HystrixCommand(fallbackMethod = "errorHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })
    @HystrixCommand
    @RequestMapping("/bad/{id}")
    public String bad(@PathVariable("id") Long id) {
        return paymentService.bad(id);
    }

    public String errorHandler(@PathVariable("id") Long id) {
        return "服务器异常，请稍后重试";
    }

    public String errorGlobalHandler() {
        return "服务异常，请稍后再试 (￣▽￣)";
    }
}
