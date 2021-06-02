package com.elean.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Elean
 * @Date 2021/5/18 22:44
 * @Description
 * @Version 1.0.0
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("baidu_news", r->r.path("/guonei")
                //.filters(f->f.circuitBreaker(c->c.setName("").setFallbackUri("")).rewritePath("", ""))
                        .uri("http://news.baidu.com/guonei")).build();
    }
}
