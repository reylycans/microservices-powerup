package com.pragma.hexagonal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class HexagonalApplication {



	public static void main(String[] args) {
		SpringApplication.run(HexagonalApplication.class, args);
	}



}
