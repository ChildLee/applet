package com.applet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.applet.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class Application {
    public void a() {
        System.out.println(1);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
