package org.example.heima.orderservice;

import org.example.heima.feignapi.client.UserClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// Sep 9, 2021
@MapperScan("org.example.heima.orderservice.mapper")
@EnableFeignClients(basePackageClasses = UserClient.class)
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
