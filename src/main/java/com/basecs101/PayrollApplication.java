package com.basecs101;

import com.basecs101.customexception.EmployeeNotFoundAdvice;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;

@Slf4j
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.basecs101")
@SpringBootApplication
public class PayrollApplication {

	@Value("${firstName}")
	String firstName;

	@Value("${lastName}")
	String lastName;

	public static void main(String[] args) {

		SpringApplication.run(PayrollApplication.class, args);
		log.info("Payroll Application started...");

	}

	@PostConstruct
	void afterInit(){
		log.info("Inside post construct ");
		log.info("FirstName : "+firstName + " LastName : "+lastName);
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmployeeNotFoundAdvice.class);
		applicationContext.scan("com.basecs101");
		log.info("Test whether EmployeeNotFoundAdvice bean is created : " + applicationContext.getBean(EmployeeNotFoundAdvice.class));
	}
}