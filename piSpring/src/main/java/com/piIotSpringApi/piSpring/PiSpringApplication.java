package com.piIotSpringApi.piSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PiSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiSpringApplication.class, args);
	}
}
