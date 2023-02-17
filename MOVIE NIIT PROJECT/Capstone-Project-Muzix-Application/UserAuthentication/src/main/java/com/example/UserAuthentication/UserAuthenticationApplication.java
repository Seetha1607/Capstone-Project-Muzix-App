package com.example.UserAuthentication;

import com.example.UserAuthentication.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class UserAuthenticationApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(UserAuthenticationApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/api/v1/user/*");
		return filterRegistrationBean;
	}
}
