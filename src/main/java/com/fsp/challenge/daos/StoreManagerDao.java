package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fsp.challenge.entities.StoreManager;
import com.fsp.challenge.repositories.StoreManagerRepository;


@RestController
public class StoreManagerDao {
	@Autowired
	StoreManagerRepository storeManagerRepository;

	@PostMapping("/api/storeManager")
	public StoreManager createStoreManager(@RequestBody StoreManager storeManager) {
		return storeManagerRepository.save(storeManager);
	}
	
	@GetMapping("/api/storeManager")
	public Iterable<StoreManager> findAllStoreManagers() {
		return storeManagerRepository.findAll();
	}
	
	@GetMapping("/api/storeManager/{storeManagerId}")
	public StoreManager findStoreManagerById(
			@PathVariable("storeManagerId") int id) {
		return storeManagerRepository.findOne(id);
	}

	@PutMapping("/api/storeManager/{storeManagerId}")
	public StoreManager updateStoreManager(
			@PathVariable("storeManagerId") int id,
			@RequestBody StoreManager newStoreManager) {
		StoreManager storeManager = storeManagerRepository.findOne(id);
		storeManager.set(newStoreManager);
		return storeManagerRepository.save(storeManager);
	}
	
	@DeleteMapping("/api/storeManager/{storeManagerId}")
	public void deleteStoreManager
	(@PathVariable("storeManagerId") int id) {
		storeManagerRepository.delete(id);
	}
	
	/*public void test() {
		// Delete all store managers
		List<StoreManager> storeManagers = (List<StoreManager>) findAllStoreManagers();
		for(StoreManager storeManager: storeManagers) {
			deleteStoreManager(storeManager.getId());
		}
	}*/
}
