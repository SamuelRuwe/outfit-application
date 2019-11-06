package com.outfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //(scanBasePackageClasses = [WeatherConfig::class])
public class WebMain {

	public static void main(String[] args) {
		SpringApplication.run(WebMain.class, args);
	}
}
