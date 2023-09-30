package com.spront.spront;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.spront.spront.dao")
@SpringBootApplication
public class SprontApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprontApplication.class, args);
    }

}
