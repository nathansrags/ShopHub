package com.shophub.model;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShopHubApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopHubApiGatewayApplication.class, args);
	}

	@Bean
	public HttpClient httpClient(){
		return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
	}

}
