package com.cc.smartx;

import com.cc.smartx.user.codehelper.User;
import com.cc.smartx.user.codehelper.UserService;
import com.sun.deploy.config.DefaultConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

@SpringBootApplication(scanBasePackages = {"com.cc.smartx"})
@Import(DefaultConfig.class)
@MapperScan(basePackages = "com.cc.smartx")
public class SmartxDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartxDaoApplication.class, args);
    }

}
