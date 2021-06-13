package com.elean.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Elean
 * @Date 2021/6/12 23:31
 * @Description
 * @Version 1.0.0
 */
@RestController
public class ConfigController {
    @Value("${config.info}")
    private String info;

    @GetMapping("/get/info")
    public String getInfo() {
        return info;
    }
}
