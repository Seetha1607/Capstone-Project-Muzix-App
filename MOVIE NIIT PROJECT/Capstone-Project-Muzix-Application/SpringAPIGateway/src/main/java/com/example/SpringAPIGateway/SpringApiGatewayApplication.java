package com.example.SpringAPIGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableEurekaClient
public class SpringApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/api/v1/**")
						.uri("lb://authentication-service:8085/")) // use the name of the application in the uri

				.route(p->p
						.path("/api/v2/register","/api/v3/**")
						.uri("lb://user-movie-service:8081/"))

				.route(p -> p
						.path("/api/v4/**")
						.uri("http://favourite-movie-service:8082/"))
				.build();
	}

}
