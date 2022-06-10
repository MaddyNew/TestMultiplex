package com.mutiplex.screen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ScreenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScreenApplication.class, args);
	}

}
