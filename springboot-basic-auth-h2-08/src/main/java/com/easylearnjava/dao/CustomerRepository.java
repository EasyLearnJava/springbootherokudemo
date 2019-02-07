package com.easylearnjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easylearnjava.model.Customer;

public interface  CustomerRepository extends JpaRepository<Customer, Long> {

}
