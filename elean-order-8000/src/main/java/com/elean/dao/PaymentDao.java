package com.elean.dao;

import com.elean.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    int add(Payment payment);
    Payment getById(Long id);
}
