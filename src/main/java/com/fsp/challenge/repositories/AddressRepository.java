package com.fsp.challenge.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fsp.challenge.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
