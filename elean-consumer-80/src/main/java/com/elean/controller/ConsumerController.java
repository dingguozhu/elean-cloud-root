package com.elean.controller;

import com.elean.entities.CommonResult;
import com.elean.entities.Payment;
import com.elean.lb.LoadBalance;
import com.elean.lb.MyLb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author Elean
 * @Date 2021/4/24 21:43
 * @Description
 * @Version 1.0.0
 */

@RestController
@Slf4j
@RequestMapping("/consumer")
public class ConsumerController {

//    private static final String PAYMENT_URL = "http://localhost:8000";
    private static final String PAYMENT_URL = "http://elean-order-service";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalance loadBalance;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/order/payment/" + id, CommonResult.class);
    }

    @GetMapping("/add")
    public CommonResult<Payment> add(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/order/add", payment, CommonResult.class);
    }

    @RequestMapping("/myLb")
    public String getServerPort() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("elean-order-service");
        if (serviceInstances.isEmpty()) {
            return null;
        }
        ServiceInstance instance = loadBalance.instance(serviceInstances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/order/port", String.class);
    }
}
