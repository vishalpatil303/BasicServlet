package com.amigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amigos.modal.Customer;
import com.amigos.service.CustomerServiceInterface;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceInterface customerService;

//	@RequestMapping(path = "/api/v1/customer",
//						method = RequestMehtod.GET)
	@GetMapping("/api/v1/customer")
	public List<Customer> getAllCustomer(){
		return customerService.findAllCustomers();
	}

	@GetMapping("/api/v1/customer/{id}")
	public Customer getCustomerById(@PathVariable(name = "id") Long id) {
		return customerService.findCustomerById(id);
	}



}
