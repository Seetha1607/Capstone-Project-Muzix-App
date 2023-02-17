package com.example.FavouriteMovieService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FavouriteMovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavouriteMovieServiceApplication.class, args);
	}

}
