package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fsp.challenge.entities.Promo;
import com.fsp.challenge.entities.Store;
import com.fsp.challenge.repositories.PromoRepository;
import com.fsp.challenge.repositories.StoreRepository;

@RestController
public class PromoDao {
	@Autowired
	PromoRepository promoRepository;
	@Autowired
	StoreRepository storeRepository;

	@PostMapping("/api/promo")
	public Promo createPromo(@RequestBody Promo promo) {
		return promoRepository.save(promo);
	}
	
	// shouldn't expose all promo codes
	/*@GetMapping("/api/promo")
	public Iterable<Promo> findAllPromos() {
		return promoRepository.findAll();
	}*/
	
	@GetMapping("/api/promo/{promoId}")
	public Promo findPromoById(
			@PathVariable("promoId") String id) {
		return promoRepository.find(id);
	}
	
	@PutMapping("/api/promo/{promoId}/store/{storeId}")
	public Promo addStore(@PathVariable("promoId") String id,
			@PathVariable("storeId") int sid) {
		Promo promo = promoRepository.find(id);
		Store store = storeRepository.findOne(sid);
		promo.setStore(store);
		return promoRepository.save(promo);
	}


	@PutMapping("/api/promo/{promoCode}")
	public Promo updatePromo(
			@PathVariable("promoCode") String code,
			@RequestBody Promo newPromo) {
		Promo promo = promoRepository.find(code);
		promo.set(newPromo);
		return promoRepository.save(promo);
	}
	
	@DeleteMapping("/api/promo/{promoId}")
	public void deletePromo
	(@PathVariable("promoId") String id) {
		promoRepository.deletePromo(id);
	}
	
	/*public void test() {
		// Delete all promos
		List<Promo> promos = (List<Promo>) findAllPromos();
		for(Promo promo : promos) {
			deletePromo(promo.getId());
		}
	}*/
}
