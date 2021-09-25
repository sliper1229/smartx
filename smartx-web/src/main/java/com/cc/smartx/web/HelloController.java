package com.cc.smartx.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @Author chenlipeng
 * @Date 2020-06-06
 */
@RestController
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello world!";
    }
}