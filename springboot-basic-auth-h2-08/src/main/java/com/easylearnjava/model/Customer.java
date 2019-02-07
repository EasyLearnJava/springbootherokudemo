package com.easylearnjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Column(name="id")
	private Long id;
	private String name;
	private String role;
	private String emailId;
	private String password;
	
	
	public Customer(String name, String role, String emailId, String password) {
		this.name = name;
		this.role = role;
		this.emailId = emailId;
		this.password = password;
	}

}
