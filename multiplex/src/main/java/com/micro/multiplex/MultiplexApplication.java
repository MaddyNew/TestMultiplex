package com.micro.multiplex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MultiplexApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiplexApplication.class, args);
	}

}
