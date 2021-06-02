package com.elean.service.handler;

import com.elean.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @Author Elean
 * @Date 2021/5/16 23:18
 * @Description Hystrix降级处理方式三
 * @Version 1.0.0
 */

@Component
public class PaymentServiceHandler implements PaymentService {
    @Override
    public String good(Long id) {
        return "调用正常方法失败，请稍后重试！";
    }

    @Override
    public String bad(Long id) {
        return "调用异常方法失败，请稍后重试！";
    }
}
