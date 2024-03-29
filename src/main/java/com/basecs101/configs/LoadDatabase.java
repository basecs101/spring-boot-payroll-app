package com.basecs101.configs;

import com.basecs101.model.Employee;
import com.basecs101.model.Order;
import com.basecs101.model.Status;
import com.basecs101.repository.EmployeeRepository;
import com.basecs101.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    @Qualifier("cmdLineRunner")
    CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                log.info("Preloading " + repository.save(new Employee("SE","Vikram","Gupta")));
                log.info("Preloading " + repository.save(new Employee("ST","Vivek","Gupta")));

                orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
                orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

                orderRepository.findAll().forEach(order -> {
                    log.debug("Preloaded " + order);
                });
            }
        };
    }
}