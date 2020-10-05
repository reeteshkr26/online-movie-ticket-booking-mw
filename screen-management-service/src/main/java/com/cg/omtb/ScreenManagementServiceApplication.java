package com.cg.omtb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.cg.omtb.service")
@EnableDiscoveryClient
public class ScreenManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScreenManagementServiceApplication.class, args);
	}

}
