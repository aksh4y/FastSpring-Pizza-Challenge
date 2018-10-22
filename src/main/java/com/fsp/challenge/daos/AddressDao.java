package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fsp.challenge.entities.Address;
import com.fsp.challenge.repositories.AddressRepository;

@RestController
public class AddressDao {
	@Autowired
	AddressRepository addressRepository;

	@PostMapping("/api/address")
	public Address createAddress(@RequestBody Address address) {
		return addressRepository.save(address);
	}
	
	@GetMapping("/api/address")
	public Iterable<Address> findAllAddresss() {
		return addressRepository.findAll();
	}
	
	@GetMapping("/api/address/{addressId}")
	public Address findAddressById(
			@PathVariable("addressId") int id) {
		return addressRepository.findOne(id);
	}

	@PutMapping("/api/address/{addressId}")
	public Address updateAddress(
			@PathVariable("addressId") int id,
			@RequestBody Address newAddress) {
		Address address = addressRepository.findOne(id);
		address.set(newAddress);
		return addressRepository.save(address);
	}
	
	@DeleteMapping("/api/address/{addressId}")
	public void deleteAddress
	(@PathVariable("addressId") int id) {
		addressRepository.delete(id);
	}
	
	/*public void test() {
		// Delete all addresss
		List<Address> addresss = (List<Address>) findAllAddresss();
		for(Address address : addresss) {
			deleteAddress(address.getId());
		}
	}*/
}
