package com.gateprehub.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GatePrepHubApplication {

	public static void main(String[] args) {
		System.out.println("Started Main Function");
		SpringApplication.run(GatePrepHubApplication.class, args);
	}

}