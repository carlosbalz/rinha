package com.rinha.rinha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;

@SpringBootApplication
@Cacheable
public class RinhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RinhaApplication.class, args);
	}

}
