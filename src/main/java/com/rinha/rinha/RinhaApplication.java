package com.rinha.rinha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Cacheable
@EnableScheduling
@EnableAutoConfiguration
public class RinhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RinhaApplication.class, args);
	}

}
