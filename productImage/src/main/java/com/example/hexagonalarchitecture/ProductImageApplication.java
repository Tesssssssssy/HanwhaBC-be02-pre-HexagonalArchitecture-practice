package com.example.hexagonalarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductImageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductImageApplication.class, args);
    }
}