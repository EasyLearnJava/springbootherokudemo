package com.easylearnjava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.easylearnjava.model.Customer;
import com.easylearnjava.util.CustomerNotFoundException;

@RestController
public class CustomerResource {

	static List<Customer> customerlist = new ArrayList<Customer>();

	static {
		
		Customer c1 = new Customer(Long.valueOf(1), "Raghu", "Admin", "raghu@test.com", "secret");
		Customer c2 = new Customer(Long.valueOf(2), "Ramya", "Premium Customer", "ramya@test.com", "topsecret");
		customerlist.add(c1);
		customerlist.add(c2);
	}

	@GetMapping("/customers")
	List<Customer> all() {
		return customerlist;
	}

	@PostMapping("/customers")
	Customer newCustomer(@RequestBody Customer newCustomer) {
		Long size = (long) customerlist.size();
		newCustomer.setId(size+1);
		customerlist.add(newCustomer);
		return newCustomer;
	}

	// Single item

	@GetMapping("/customers/{id}")
	Customer one(@PathVariable Long id) {

		try {
		return customerlist.get(id.intValue()-1);
		}catch(Exception e) {
			throw new CustomerNotFoundException(id);
		}		
	}

	@PutMapping("/customers/{id}")
	Customer replaceCustomerModel(@RequestBody Customer newCustomer, @PathVariable Long id) {

		Long size = (long) customerlist.size();
		if(id > size) {
			newCustomer.setId(size+1);
			customerlist.add(newCustomer);
			return newCustomer;
		}else {
			Customer customer = customerlist.get(id.intValue()-1);
			customerlist.remove(customer);
			newCustomer.setId(id);
			customerlist.add(newCustomer);
			return newCustomer;
		}		
	}

	@DeleteMapping("/customers/{id}")
	void deleteCustomerModel(@PathVariable Long id) {
		customerlist.remove(customerlist.get(id.intValue()-1));
	}

}
