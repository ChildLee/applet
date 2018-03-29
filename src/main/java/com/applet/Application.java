package com.applet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.applet.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class Application {


    public void ppppp() {
        System.out.println("ppppppppppppppppppppp");
    }

    public void  aaa(){
        System.out.println("123");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
