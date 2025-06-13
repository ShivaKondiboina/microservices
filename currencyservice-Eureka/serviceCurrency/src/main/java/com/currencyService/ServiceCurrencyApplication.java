package com.currencyService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class ServiceCurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCurrencyApplication.class, args);
	}

}
