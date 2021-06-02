package com.elean.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Elean
 * @Date 2021/5/12 22:36
 * @Description
 * @Version 1.0.0
 */
@Component
public class MyLb implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 214748367 ? 0 : current + 1;
            //CAS 自旋锁
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("--------------->next:" + next);
        return next;
    }
}
