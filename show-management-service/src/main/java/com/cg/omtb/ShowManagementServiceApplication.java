package com.cg.omtb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.cg.omtb.service")
@SpringBootApplication
@EnableDiscoveryClient
public class ShowManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowManagementServiceApplication.class, args);
	}

}
