package com.elean.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author Elean
 * @Date 2021/5/12 22:04
 * @Description
 * @Version 1.0.0
 */
public interface LoadBalance {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
