package com.easylearnjava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {
	
	@Id @GeneratedValue
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

}
