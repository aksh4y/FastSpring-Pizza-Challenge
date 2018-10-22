package com.fsp.challenge.repositories;


import org.springframework.data.repository.CrudRepository;

import com.fsp.challenge.entities.pizza.Topping;

public interface ToppingRepository extends CrudRepository<Topping, Integer> {

}
