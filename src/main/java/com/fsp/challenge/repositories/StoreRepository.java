package com.fsp.challenge.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fsp.challenge.entities.Store;

public interface StoreRepository extends CrudRepository<Store, Integer> {
	
}
