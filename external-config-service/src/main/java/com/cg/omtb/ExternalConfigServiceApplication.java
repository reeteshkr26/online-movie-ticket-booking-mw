package com.cg.omtb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ExternalConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalConfigServiceApplication.class, args);
	}

}
