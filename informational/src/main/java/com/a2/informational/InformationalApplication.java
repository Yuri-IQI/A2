package com.a2.informational;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InformationalApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationalApplication.class, args);
	}

}
