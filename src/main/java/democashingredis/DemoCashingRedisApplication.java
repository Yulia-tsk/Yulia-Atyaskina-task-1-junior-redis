package com.example.democashingredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoCashingRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCashingRedisApplication.class, args);
	}

}
