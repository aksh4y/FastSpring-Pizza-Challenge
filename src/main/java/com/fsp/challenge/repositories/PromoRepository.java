package com.fsp.challenge.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fsp.challenge.entities.Promo;

public interface PromoRepository extends CrudRepository<Promo, Integer> {
	@Query("SELECT p FROM Promo p WHERE LOWER(p.code) = LOWER(:code)")
    public Promo find(@Param("code") String code);

	@Query("DELETE FROM Promo WHERE LOWER(code) = LOWER(:code)")
	public void deletePromo(String code);
}
