package com.shophub.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShopHubEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopHubEurekaApplication.class, args);
	}

}
