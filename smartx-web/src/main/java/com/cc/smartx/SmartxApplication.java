package com.cc.smartx;

import com.cc.smartx.spring.listener.ApplicationStartedEventListener;
import com.sun.deploy.config.DefaultConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = {"com.cc.smartx"})
@Import(DefaultConfig.class)
//@ImportResource(locations="classpath:context/spring-jsf-consumer")
public class SmartxApplication {

    public static void main(String[] args) {
        /**
         * 这一行代码干了下面两件事：
         * 实例化SpringApplication：new SpringApplication
         * 启动应用程序：application.run()
         */
        //SpringApplication.run(SmartxApplication.class, args);

        // 手动实例化SpringApplication方式
        SpringApplication application = new SpringApplication(SmartxApplication.class);
        // 添加注册监听器
        application.addListeners(new ApplicationStartedEventListener());
        // 启动应用程序
        application.run(args);

    }

}
