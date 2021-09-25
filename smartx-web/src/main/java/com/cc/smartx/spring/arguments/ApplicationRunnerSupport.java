package com.cc.smartx.spring.arguments;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * java -jar xxx.jar --skip noway
 *
 * @description: 实现ApplicationRunner接口获取ApplicationArguments实例对象
 * @Author chenlipeng
 * @Date 2020-06-06
 */
@Component
public class ApplicationRunnerSupport implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        boolean isHaveSkip = args.containsOption("skip");
        System.out.println("skip：" + isHaveSkip);
        System.out.println(args.getOptionValues("skip"));
    }
}
