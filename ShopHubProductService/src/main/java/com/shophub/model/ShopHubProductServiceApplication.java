package com.shophub.model;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.shophub.model.entity")
public class ShopHubProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopHubProductServiceApplication.class, args);
	}
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}
