package com.basecs101;

import com.basecs101.configs.LoadDatabase;
import com.basecs101.controllers.EmployeeController;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.basecs101")
//@SpringBootApplication
public class PayrollApplication {

	public static void main(String[] args) {

		SpringApplication.run(PayrollApplication.class, args);
		log.info("Payroll Application started...");

	}

//	@PostConstruct
//	void afterInit(){
//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LoadDatabase.class);
//		System.out.println("Test whether bean is created : " + applicationContext.getBean(CommandLineRunner.class));
//	}

}