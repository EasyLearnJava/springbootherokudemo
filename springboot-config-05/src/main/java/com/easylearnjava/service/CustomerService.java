package com.easylearnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.easylearnjava.dao.CustomerRepository;
import com.easylearnjava.model.Customer;
import com.easylearnjava.util.CustomerNotFoundException;

@Component
public class CustomerService {
	
	@Autowired
	CustomerRepository repository;
	
	
	@Cacheable("customers")
	public List<Customer> all() {		
		return repository.findAll();
	}
	
	public Customer newCustomer(Customer newCustomer) {
		return repository.save(newCustomer);
	}
	
	@Cacheable("customer")
	public Customer one(Long id) {		
		System.out.println("************ Strat Fetching Customer Record with Id : " + id);
		Customer customer = repository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(id));
		System.out.println("************ Completed Fetching Customer Record with Id : " + id);
		return customer;
	}
	
	@CachePut
	public Customer replaceCustomerModel(Customer newCustomer, Long id) {
		return repository.findById(id)
				.map(customer -> {
					customer.setName(newCustomer.getName());
					customer.setRole(newCustomer.getRole());
					customer.setEmailId(newCustomer.getEmailId());
					customer.setPassword(newCustomer.getPassword());
					return repository.save(customer);
				})
				.orElseGet(() -> {
					newCustomer.setId(id);
					return repository.save(newCustomer);
				});
	}
	
	public 	void deleteCustomerModel(Long id) {
		repository.deleteById(id);
	}
	
}
