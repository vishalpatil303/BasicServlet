package com.amigos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amigos.modal.Customer;
import com.amigos.repository.CustomerRepository;
@Service
public class CustomerService implements CustomerServiceInterface {

	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAllCustomers() {

		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer findCustomerById(Long id) {
		if (customerRepository.existsById(id)) {
			Customer customer = customerRepository.findById(id).get();
			return customer;
		}
		return null;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer savedCustomer = null;
		if(customer.getId() == null) {
			savedCustomer = customerRepository.save(customer);

		}else {
			Customer foundCustomer = customerRepository.findById(customer.getId()).get();
			Customer c = editCustomerFields(customer,foundCustomer);
			savedCustomer = customerRepository.save(c);
		}
		return savedCustomer;
	}

	private Customer  editCustomerFields(Customer customer, Customer foundCustomer) {

		customer.setName( customer.getName() == null||customer.getName().toString().trim().length() == 0 ? foundCustomer.getName() :customer.getName());
		customer.setEmail( customer.getEmail() == null||customer.getEmail().toString().trim().length() == 0 ? foundCustomer.getEmail() :customer.getEmail());
		customer.setBirthday( customer.getBirthday() == null||customer.getBirthday().toString().trim().length() == 0 ? foundCustomer.getBirthday() :customer.getBirthday());

		return customer;
	}

	@Override
	public List<Customer> saveAllCustomer(List<Customer> customers) {
		List<Customer> customerList = customerRepository.saveAll(customers);
		return customerList;
	}

}
