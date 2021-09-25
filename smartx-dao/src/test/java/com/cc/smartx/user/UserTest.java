package com.cc.smartx.user;

import com.cc.smartx.user.codehelper.User;
import com.cc.smartx.user.codehelper.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cc.smartx.SmartxDaoApplication;

import javax.annotation.Resource;

/**
 * @description:
 * @Author chenlipeng
 * @Date 2020-06-15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SmartxDaoApplication.class)
public class UserTest {

    @Resource
    private UserService userService;

    private static final Logger logger = Logger.getLogger(UserTest.class);

    @Test
    public void test() {
        User user = new User();
        userService.insert(user);
        logger.info("111");
    }

}


