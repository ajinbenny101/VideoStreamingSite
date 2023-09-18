package com.fdmgroup.vodappapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class VodAppApiApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(VodAppApiApplication.class, args);
	}

	@Bean
  	public WebMvcConfigurer mvcConfigurer() 
	{
    	return new WebMvcConfigurer() 
		{
			@Override
			public void addCorsMappings(CorsRegistry registry) 
			{
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
    	};
  	}
}

