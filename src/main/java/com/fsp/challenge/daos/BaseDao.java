package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsp.challenge.entities.pizza.Base;
import com.fsp.challenge.repositories.BaseRepository;

@RestController
public class BaseDao {
	@Autowired
	BaseRepository baseRepository;

	@PostMapping("/api/base")
	public Base createBase(@RequestBody Base base) {
		return baseRepository.save(base);
	}
	
	@GetMapping("/api/base")
	public Iterable<Base> findAllBases() {
		return baseRepository.findAll();
	}
	
	@GetMapping("/api/base/{baseId}")
	public Base findBaseById(
			@PathVariable("baseId") int id) {
		return baseRepository.findOne(id);
	}

	@PutMapping("/api/base/{baseId}")
	public Base updateBase(
			@PathVariable("baseId") int id,
			@RequestBody Base newBase) {
		Base base = baseRepository.findOne(id);
		base.set(newBase);
		return baseRepository.save(base);
	}
	
	@DeleteMapping("/api/base/{baseId}")
	public void deleteBase
	(@PathVariable("baseId") int id) {
		baseRepository.delete(id);
	}
	
	/*public void test() {
		// Delete all bases
		List<Base> bases = (List<Base>) findAllBases();
		for(Base base : bases) {
			deleteBase(base.getId());
		}
	}*/
}
