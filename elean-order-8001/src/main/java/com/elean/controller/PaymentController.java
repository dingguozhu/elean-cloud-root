package com.elean.controller;

import com.elean.entities.CommonResult;
import com.elean.entities.Payment;
import com.elean.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author Elean
 * @Date 2021/4/24 16:23
 * @Description
 * @Version 1.0.0
 */
@RequestMapping("/order")
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private PaymentService paymentService;

    //服务发现配置
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        return new CommonResult<Payment>(200, "获取成功port:" + serverPort, payment);
    }

    @PostMapping("/add")
    public CommonResult add(@RequestBody Payment payment) {
        int add = paymentService.add(payment);
        log.info("插入结果" + add);
        return new CommonResult(200, "添加成功");
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();

        for (String s : services) {
            log.info("------------>services:" + s);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("ELEAN-ORDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("clients:" + instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @RequestMapping("/port")
    public String getServerPort() {
        return serverPort;
    }

    @RequestMapping("/timeout")
    public String openfeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
