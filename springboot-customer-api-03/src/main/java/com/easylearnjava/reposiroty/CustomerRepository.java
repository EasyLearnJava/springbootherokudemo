package com.easylearnjava.reposiroty;

import java.util.ArrayList;
import java.util.List;

import com.easylearnjava.model.Customer;

public class CustomerRepository {
	
	static List<Customer> customerlist = new ArrayList<Customer>();
	
	static {	
		Customer c1 =  new Customer(Long.valueOf(1), "Raghu", "Admin", "raghu@test.com", "secret");
		Customer c2 =  new Customer(Long.valueOf(2), "Ramya", "Premium Customer", "ramya@test.com", "topsecret");
		customerlist.add(c1);
		customerlist.add(c2);
	}
	
	public List<Customer> all(){
		return customerlist;
	}

}
