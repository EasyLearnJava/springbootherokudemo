package com.easylearnjava.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.easylearnjava.model.Customer;
import com.easylearnjava.service.CustomerService;

@RestController
public class CustomerResource {
	
	@Autowired
	CustomerService service;

	
	@GetMapping("/customers")
	List<Customer> all() {		
		return service.all();
	}
	

	@PostMapping("/customers")
	Customer newCustomer(@RequestBody Customer newCustomer) {
		return service.newCustomer(newCustomer);
	}
	

	@GetMapping("/customers/{id}")
	Customer one(@PathVariable Long id) {			
		return service.one(id);
	}
	

	@PutMapping("/customers/{id}")
	Customer replaceCustomerModel(@RequestBody Customer newCustomer, @PathVariable Long id) {
		return service.replaceCustomerModel(newCustomer, id);
	}

	
	@DeleteMapping("/customers/{id}")
	void deleteCustomerModel(@PathVariable Long id) {
		service.deleteCustomerModel(id);
	}

}
