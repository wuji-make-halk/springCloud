package com.square;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@MapperScan(basePackages = "com.square.dao")
public class TensquareRecruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareRecruitApplication.class, args);
    }

}
