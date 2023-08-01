package com.amigos.service;

import java.util.List;

import com.amigos.modal.Customer;

public interface CustomerServiceInterface {


	List<Customer> findAllCustomers();
	Customer findCustomerById(Long id);
	Customer saveCustomer(Customer customer);
	List<Customer> saveAllCustomer(List<Customer> customers);
}
