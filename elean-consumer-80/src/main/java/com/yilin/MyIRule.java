package com.yilin;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Elean
 * @Date 2021/5/11 22:44
 * @Description
 * @Version 1.0.0
 */
@Configuration
public class MyIRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
