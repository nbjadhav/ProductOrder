package com.productOrder.productOrderDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.productOrder.productOrderDetails")
public class ProductOrderDetailsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProductOrderDetailsApplication.class, args);
	}

	/*
	 * @Configuration class config{
	 * 
	 * @LoadBalanced
	 * 
	 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); } }
	 */ 
}
