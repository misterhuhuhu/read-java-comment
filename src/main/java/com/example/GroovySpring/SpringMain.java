package com.example.GroovySpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) {
        var applicationContext = new SpringApplication(SpringMain.class).run(args);
        var bean = applicationContext.getBean(UserService.class);
        System.out.println(bean.findById(11).name);
    
        var foo = new Foo();
        SpringContextUtils.autowireBean(foo);//自动注入
        System.out.println("Foo"+foo.run());
    }
}
