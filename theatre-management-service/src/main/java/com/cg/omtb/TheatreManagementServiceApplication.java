package com.cg.omtb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TheatreManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreManagementServiceApplication.class, args);
	}

}
