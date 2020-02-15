package com.zt.ailpayspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zt.ailpayspringboot.mapper")
public class AilpaySpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AilpaySpringbootApplication.class, args);
    }

}
