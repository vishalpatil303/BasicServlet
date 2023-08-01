package com.amigos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigos.modal.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
