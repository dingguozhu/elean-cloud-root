package com.elean.service;

import com.elean.entities.Payment;

/**
 * @Author Elean
 * @Date 2021/4/24 16:17
 * @Description
 * @Version 1.0.0
 */
public interface PaymentService {
    int add(Payment payment);
    Payment getById(Long id);
}
