package com.yuchiapi.yuchiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YuchiApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(YuchiApiApplication.class, args);
    }
}
