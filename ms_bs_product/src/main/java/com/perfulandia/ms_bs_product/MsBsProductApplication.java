package com.perfulandia.ms_bs_product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsBsProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBsProductApplication.class, args);
	}

}
