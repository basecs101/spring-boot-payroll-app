package com.basecs101.configs;

import com.basecs101.model.Employee;
import com.basecs101.model.Order;
import com.basecs101.model.Status;
import com.basecs101.repository.EmployeeRepository;
import com.basecs101.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    @Qualifier("cmdLineRunner")
    CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                Employee employee = new Employee("SE","Vikram","Gupta");
                log.info("Preloading " + repository.save(employee));
                log.info("Preloading " + repository.save(new Employee("ST","Vivek","Gupta")));

                orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
                orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

                orderRepository.findAll().forEach(order -> {
                    log.info("Preloaded " + order);
                });
            }
        };
    }
}