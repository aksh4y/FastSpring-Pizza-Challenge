package com.fsp.challenge.repositories;


import org.springframework.data.repository.CrudRepository;
import com.fsp.challenge.entities.pizza.Sauce;

public interface SauceRepository extends CrudRepository<Sauce, Integer> {

}
