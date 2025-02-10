package com.a2.lethargy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LethargyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LethargyApplication.class, args);
	}

}
