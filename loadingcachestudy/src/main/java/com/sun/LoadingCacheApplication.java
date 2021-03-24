package com.sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LoadingCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadingCacheApplication.class, args);
	}

}
