package com.vishva.Payapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class PayappApplication {

	public static void main(String[] args) {

		SpringApplication.run(PayappApplication.class, args);
	}

	@Bean // Want a new obj every time
	@Scope("prototype")
	public ModelMapper modelMapper() {

		return new ModelMapper();
	}
}
