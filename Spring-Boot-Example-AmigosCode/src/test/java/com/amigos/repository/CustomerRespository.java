package com.amigos.repository;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amigos.modal.Customer;
import com.amigos.service.CustomerServiceInterface;

@SpringBootTest
public class CustomerRespository {

	@Autowired
	private CustomerRepository customerRepository ;
	@Autowired
	private CustomerServiceInterface customerService;

	@Test
	void saveCustomerTes() {
		Customer c = new Customer("Vishal","vishal.patil303@gmail.com",LocalDate.of(1987, 11, 06));
		Customer c1 = new Customer("Shivam","shivam.patil303@gmail.com",LocalDate.of(2016, 8, 02));
		Customer c2 = new Customer("Tushar","tushar.patil303@gmail.com",LocalDate.of(1990, 10, 20));
		Customer c3 = new Customer("Akshaj","akshaj.patil303@gmail.com",LocalDate.of(2018, 9, 23));

		List<Customer> customers = customerService.saveAllCustomer(List.of(c,c1,c2,c3));
	}
}
