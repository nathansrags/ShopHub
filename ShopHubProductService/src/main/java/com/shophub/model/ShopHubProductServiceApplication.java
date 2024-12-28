package com.shophub.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
@EnableDiscoveryClient
public class ShopHubProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopHubProductServiceApplication.class, args);
	}
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}
