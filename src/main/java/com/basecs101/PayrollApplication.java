package com.basecs101;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class PayrollApplication {

	public static void main(String[] args) {
		log.info("Payroll Application started...");
		SpringApplication.run(PayrollApplication.class, args);
	}

}