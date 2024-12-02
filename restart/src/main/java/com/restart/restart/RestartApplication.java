package com.restart.restart;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestartApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestartApplication.class, args);
	}
	@Bean
	public ModelMapper getModelmapper(){
      return new ModelMapper();
   }
}
