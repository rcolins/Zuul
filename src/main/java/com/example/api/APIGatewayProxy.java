package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class APIGatewayProxy {

	public static void main(String[] args) {
		SpringApplcation.run(APIGatewayProxy.class, args);
	}
}
