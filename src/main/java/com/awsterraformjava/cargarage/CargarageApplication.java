package com.awsterraformjava.cargarage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CargarageApplication {
	public static void main(String[] args) {
		SpringApplication.run(CargarageApplication.class, args);
	}

}
