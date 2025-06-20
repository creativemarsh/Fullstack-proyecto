package com.perfulandia.ms_bs_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsBsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBsClientApplication.class, args);
	}

}
