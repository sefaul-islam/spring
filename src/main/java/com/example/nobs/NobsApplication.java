package com.example.nobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NobsApplication {

	public static void main(String[] args) {
		System.out.println("Hello world");
		SpringApplication.run(NobsApplication.class, args);
	}

}
