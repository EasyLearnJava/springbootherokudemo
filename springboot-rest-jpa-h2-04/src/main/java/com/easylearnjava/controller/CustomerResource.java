package com.easylearnjava.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.easylearnjava.dao.CustomerRepository;
import com.easylearnjava.model.Customer;
import com.easylearnjava.util.CustomerNotFoundException;

@RestController
public class CustomerResource {
	
	private final CustomerRepository repository;

	CustomerResource(CustomerRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/customers")
	List<Customer> all() {
		
		return repository.findAll();
	}

	@PostMapping("/customers")
	Customer newCustomer(@RequestBody Customer newCustomer) {
		
		return repository.save(newCustomer);
	}

	// Single item

	@GetMapping("/customers/{id}")
	Customer one(@PathVariable Long id) {		
		
		Customer customer = repository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(id));
		return customer;
	}

	@PutMapping("/customers/{id}")
	Customer replaceCustomerModel(@RequestBody Customer newCustomer, @PathVariable Long id) {
		
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

	@DeleteMapping("/customers/{id}")
	void deleteCustomerModel(@PathVariable Long id) {

		repository.deleteById(id);
	}

}
