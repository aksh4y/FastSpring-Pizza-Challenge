package com.fsp.challenge.repositories;


import org.springframework.data.repository.CrudRepository;

import com.fsp.challenge.entities.pizza.Size;

public interface SizeRepository extends CrudRepository<Size, Integer> {

}
