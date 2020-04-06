package com.square;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@CrossOrigin
public class TensquareSpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareSpitApplication.class, args);
    }

}
