package com.square;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableEurekaClient
@SpringBootApplication
@CrossOrigin
@MapperScan(basePackages = "com.square.dao")
public class TensquareArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareArticleApplication.class, args);
    }

}
