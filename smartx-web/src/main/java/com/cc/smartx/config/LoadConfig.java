package com.cc.smartx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @Author chenlipeng
 * @Date 2020-06-06
 */
@Configuration
public class LoadConfig {

    @Value("${name:''}")
    private String name;

    public String getName() {
        return name;
    }
}