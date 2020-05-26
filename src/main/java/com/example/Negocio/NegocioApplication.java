package com.example.Negocio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class NegocioApplication {

	public static void main(String[] args) {

		SpringApplication.run(NegocioApplication.class, args);

	}

}
