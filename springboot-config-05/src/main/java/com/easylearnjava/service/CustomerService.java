package com.easylearnjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.easylearnjava.dao.CustomerRepository;
import com.easylearnjava.model.Customer;
import com.easylearnjava.util.CustomerNotFoundException;

@Component
public class CustomerService {
	
	@Autowired
	CustomerRepository repository;

	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	@Cacheable("customers")
	public Customer one(@PathVariable Long id) {		
		System.out.println("11111111111111111111111111");
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Customer customer = repository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(id));
		System.out.println("222222222222222222222222222");
		return customer;
	}
	
}
