package com.usk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.usk.client")
public class EcommerceApp {

    public static void main(String[] args) {

        //SpringApplication.run(EcommerceApp.class, args);

        SpringApplication app = new SpringApplication(EcommerceApp.class);
        Map<String, Object> props = new HashMap<>();
        props.put("server.port", 8083);
        app.setDefaultProperties(props);
        app.run(args);

    }
}

