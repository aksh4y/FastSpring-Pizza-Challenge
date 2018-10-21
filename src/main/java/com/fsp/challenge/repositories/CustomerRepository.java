package com.fsp.challenge.repositories;


import org.springframework.data.repository.CrudRepository;

import com.fsp.challenge.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
