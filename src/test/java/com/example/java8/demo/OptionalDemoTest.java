package com.example.java8.demo;

import com.example.java8.model.User;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-08-28 11:05
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalDemoTest {

    @Test
    public void testGetName() {
        User user = new User();
        user.setName("scholes");

        String name = OptionalDemo.getName(user);
        log.info("返回结果：{}", name);

        user.setName(null);

        name = OptionalDemo.getName(user);
        log.info("返回结果：{}", name);

        name = OptionalDemo.getName(null);
        log.info("返回结果：{}", name);
    }
}
