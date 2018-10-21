package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fsp.challenge.entities.Store;
import com.fsp.challenge.repositories.StoreRepository;


@RestController
public class StoreDao {
	@Autowired
	StoreRepository storeRepository;

	@PostMapping("/api/store")
	public Store createStore(@RequestBody Store store) {
		return storeRepository.save(store);
	}
	
	@GetMapping("/api/store")
	public Iterable<Store> findAllStores() {
		return storeRepository.findAll();
	}
	
	@GetMapping("/api/store/{storeId}")
	public Store findStoreById(
			@PathVariable("storeId") int id) {
		return storeRepository.findOne(id);
	}

	@PutMapping("/api/store/{storeId}")
	public Store updateStore(
			@PathVariable("storeId") int id,
			@RequestBody Store newStore) {
		Store store = storeRepository.findOne(id);
		store.set(newStore);
		return storeRepository.save(store);
	}
	
	@DeleteMapping("/api/store/{storeId}")
	public void deleteStore
	(@PathVariable("storeId") int id) {
		storeRepository.delete(id);
	}
	
	/*public void test() {
		// Delete all stores
		List<Store> stores = (List<Store>) findAllStores();
		for(Store store : stores) {
			deleteStore(store.getId());
		}
	}*/
}
