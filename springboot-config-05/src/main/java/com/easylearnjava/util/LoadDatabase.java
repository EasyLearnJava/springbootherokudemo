package com.easylearnjava.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.easylearnjava.dao.CustomerRepository;
import com.easylearnjava.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(CustomerRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Customer("Raghu", "Admin", "raghu@test.com", "secret")));
			log.info("Preloading " + repository.save(new Customer("Ramya", "Premium Customer", "ramya@test.com", "topsecret")));
		};
	}
}