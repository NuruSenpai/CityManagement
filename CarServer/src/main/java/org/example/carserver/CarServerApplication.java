package org.example.carserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CarServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServerApplication.class, args);
    }

}
