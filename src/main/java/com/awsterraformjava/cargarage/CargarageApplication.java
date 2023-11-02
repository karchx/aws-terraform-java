package com.awsterraformjava.cargarage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@RestController
@SpringBootApplication
@EnableJpaAuditing
public class CargarageApplication {

	@RequestMapping("/")
    public String sayHello() {
        return "Hello and Welcome to the CarGarage application.";
    }

	public static void main(String[] args) {
		SpringApplication.run(CargarageApplication.class, args);
	}

}
