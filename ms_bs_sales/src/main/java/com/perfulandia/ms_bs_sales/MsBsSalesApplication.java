package com.perfulandia.ms_bs_sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsBsSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBsSalesApplication.class, args);
	}

}
