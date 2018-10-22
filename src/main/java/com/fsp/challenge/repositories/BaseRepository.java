package com.fsp.challenge.repositories;


import org.springframework.data.repository.CrudRepository;

import com.fsp.challenge.entities.pizza.Base;

public interface BaseRepository extends CrudRepository<Base, Integer> {

}
