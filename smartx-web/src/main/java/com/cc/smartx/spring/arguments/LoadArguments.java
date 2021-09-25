package com.cc.smartx.spring.arguments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * java -jar xxx.jar --skip noway
 *
 * @description: 构造参数注入ApplicationArguments实例对象
 * @Author chenlipeng
 * @Date 2020-06-06
 */
@Component
public class LoadArguments {
    /**
     * 构造函数注入{@link ApplicationArguments}
     *
     * @param applicationArguments
     */
    @Autowired
    public LoadArguments(ApplicationArguments applicationArguments) {
        // 判断是否存在名为skip的启动项参数
        boolean isHaveSkip = applicationArguments.containsOption("skip");
        System.out.println("skip：" + isHaveSkip);
        // 遍历输出全部的非启动项参数
        List<String> arguments = applicationArguments.getNonOptionArgs();
        for (int i = 0; i < arguments.size(); i++) {
            System.out.println("非启动项参数：" + arguments.get(i));
        }
    }
}
