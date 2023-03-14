package com.digitalmedia.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GatewayApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayApiApplication.class, args);
  }

}
