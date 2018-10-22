package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fsp.challenge.entities.Phone;
import com.fsp.challenge.repositories.PhoneRepository;

@RestController
public class PhoneDao {
	@Autowired
	PhoneRepository phoneRepository;

	@PostMapping("/api/phone")
	public Phone createPhone(@RequestBody Phone phone) {
		return phoneRepository.save(phone);
	}
	
	@GetMapping("/api/phone")
	public Iterable<Phone> findAllPhones() {
		return phoneRepository.findAll();
	}
	
	@GetMapping("/api/phone/{phoneId}")
	public Phone findPhoneById(
			@PathVariable("phoneId") int id) {
		return phoneRepository.findOne(id);
	}

	@PutMapping("/api/phone/{phoneId}")
	public Phone updatePhone(
			@PathVariable("phoneId") int id,
			@RequestBody Phone newPhone) {
		Phone phone = phoneRepository.findOne(id);
		phone.set(newPhone);
		return phoneRepository.save(phone);
	}
	
	@DeleteMapping("/api/phone/{phoneId}")
	public void deletePhone
	(@PathVariable("phoneId") int id) {
		phoneRepository.delete(id);
	}
	
	/*public void test() {
		// Delete all phones
		List<Phone> phones = (List<Phone>) findAllPhones();
		for(Phone phone : phones) {
			deletePhone(phone.getId());
		}
	}*/
}
