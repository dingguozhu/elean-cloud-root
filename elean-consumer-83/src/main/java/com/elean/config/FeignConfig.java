package com.elean.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Elean
 * @Date 2021/5/13 23:21
 * @Description
 * @Version 1.0.0
 */
@Configuration
public class FeignConfig {
    /**
     * 开启feign的日志
     * 1.配置bean
     * 2.yml配置
     * @return
     */
    @Bean
    Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }
}
