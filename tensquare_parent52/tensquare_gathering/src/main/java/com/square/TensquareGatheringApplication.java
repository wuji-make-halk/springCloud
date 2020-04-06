package com.square;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@MapperScan(basePackages = "com.square.dao")
@EnableCaching
public class TensquareGatheringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareGatheringApplication.class, args);
    }

}
