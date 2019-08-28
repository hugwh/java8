package com.example.java8.demo;

import com.example.java8.model.User;

import java.util.Optional;

/**
 * optional demo
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-08-28 10:59
 */
public class OptionalDemo {
    public static String getName(User u) {
        return Optional.ofNullable(u).map(user -> user.getName()).orElse("unknown");
    }
}
