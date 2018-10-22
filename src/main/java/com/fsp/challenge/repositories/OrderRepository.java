package com.fsp.challenge.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fsp.challenge.entities.PizzaOrder;

public interface OrderRepository extends CrudRepository<PizzaOrder, Integer> {

}
