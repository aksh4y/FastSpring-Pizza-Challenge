package com.fsp.challenge.repositories;


import org.springframework.data.repository.CrudRepository;

import com.fsp.challenge.entities.pizza.Cheese;

public interface CheeseRepository extends CrudRepository<Cheese, Integer> {

}
