package com.jiang.jiangauth;

import com.jiang.system.annotation.EnableYjFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableYjFeignClients
public class JiangAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiangAuthApplication.class, args);
    }

}
