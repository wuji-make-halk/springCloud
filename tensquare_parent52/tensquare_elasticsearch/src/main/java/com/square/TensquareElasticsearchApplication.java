package com.square;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class TensquareElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareElasticsearchApplication.class, args);
    }

}
