package com.basecs101.configs;

import com.basecs101.model.Employee;
import com.basecs101.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                Employee employee = new Employee("Vikram", "SE");
                log.info(employee.toString());
                log.info("Preloading " + repository.save(employee));
                log.info("Preloading " + repository.save(new Employee("Vivek", "ST")));
            }
        };
    }
}