package com.stroygen.urdis2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Urdis2Application {

    public static void main(String[] args) {
        SpringApplication.run(Urdis2Application.class, args);
    }

}
