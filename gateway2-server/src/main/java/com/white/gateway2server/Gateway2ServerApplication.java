package com.white.gateway2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Gateway2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Gateway2ServerApplication.class, args);
	}

}
