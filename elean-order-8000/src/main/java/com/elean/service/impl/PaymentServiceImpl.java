package com.elean.service.impl;

import com.elean.dao.PaymentDao;
import com.elean.entities.Payment;
import com.elean.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Elean
 * @Date 2021/4/24 16:20
 * @Description
 * @Version 1.0.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }
}
