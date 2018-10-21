package com.fsp.challenge.repositories;

import org.springframework.data.repository.CrudRepository;
import com.fsp.challenge.entities.pizza.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Integer> {

}
