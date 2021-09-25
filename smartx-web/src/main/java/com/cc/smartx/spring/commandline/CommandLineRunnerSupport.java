package com.cc.smartx.spring.commandline;

import com.cc.smartx.config.LoadConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @Author chenlipeng
 * @Date 2020-06-06
 */
@Component
public class CommandLineRunnerSupport implements CommandLineRunner {

    @Resource
    private LoadConfig loadConfig;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("name config value：" + loadConfig.getName());
    }
}
