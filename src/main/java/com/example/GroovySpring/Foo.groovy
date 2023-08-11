package com.example.GroovySpring

import org.springframework.stereotype.Component

import javax.annotation.Resource

class Foo {

    @Resource
    UserService userService;

    Object run() {
        // do something
        def user = userService.findById(666);
        if (user != null) {
            return user.name
        }
        return null
    }

}