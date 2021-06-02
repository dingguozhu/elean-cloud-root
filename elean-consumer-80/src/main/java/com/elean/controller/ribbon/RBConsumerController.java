package com.elean.controller.ribbon;

import com.elean.entities.CommonResult;
import com.elean.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Elean
 * @Date 2021/4/24 21:43
 * @Description
 * @Version 1.0.0
 */

@RestController
@Slf4j
@RequestMapping("/consumer")
public class RBConsumerController {

//    private static final String PAYMENT_URL = "http://localhost:8000";
    private static final String PAYMENT_URL = "http://elean-order-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/ribbon/pay/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/order/payment/" + id, CommonResult.class);
        if (!entity.getStatusCode().is2xxSuccessful()) {
            return new CommonResult<>(444, "操作失败！");
        }
        return entity.getBody();
    }

    @GetMapping("/ribbon/pay/add")
    public CommonResult<Payment> add(Payment payment) {
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/order/add", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return new CommonResult<>(444, "操作失败！");
        }
        return entity.getBody();
    }
}
