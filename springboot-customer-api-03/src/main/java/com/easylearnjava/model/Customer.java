package com.easylearnjava.model;

import lombok.Data;

@Data
public class Customer {
	
	private Long id;
	private String name;
	private String role;
	private String emailId;
	private String password;
	
	public Customer() {
		
	}
	
	public Customer(String name, String role, String emailId, String password) {
		this.name = name;
		this.role = role;
		this.emailId = emailId;
		this.password = password;
	}
	
	public Customer(Long id, String name, String role, String emailId, String password) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.emailId = emailId;
		this.password = password;
	}

}
