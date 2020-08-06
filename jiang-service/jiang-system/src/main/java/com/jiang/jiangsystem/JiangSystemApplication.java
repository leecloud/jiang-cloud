package com.jiang.jiangsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JiangSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiangSystemApplication.class, args);
    }

}
