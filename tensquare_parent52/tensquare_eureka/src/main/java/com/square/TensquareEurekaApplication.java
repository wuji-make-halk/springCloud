package com.square;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
class TensquareEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareEurekaApplication.class, args);
    }

}
