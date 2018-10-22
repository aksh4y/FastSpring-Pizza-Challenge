package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsp.challenge.entities.pizza.Size;
import com.fsp.challenge.repositories.SizeRepository;

@RestController
public class SizeDao {
	@Autowired
	SizeRepository sizeRepository;

	@PostMapping("/api/size")
	public Size createSize(@RequestBody Size size) {
		return sizeRepository.save(size);
	}
	
	@GetMapping("/api/size")
	public Iterable<Size> findAllSizes() {
		return sizeRepository.findAll();
	}
	
	@GetMapping("/api/size/{sizeId}")
	public Size findSizeById(
			@PathVariable("sizeId") int id) {
		return sizeRepository.findOne(id);
	}

	@PutMapping("/api/size/{sizeId}")
	public Size updateSize(
			@PathVariable("sizeId") int id,
			@RequestBody Size newSize) {
		Size size = sizeRepository.findOne(id);
		size.set(newSize);
		return sizeRepository.save(size);
	}
	
	@DeleteMapping("/api/size/{sizeId}")
	public void deleteSize
	(@PathVariable("sizeId") int id) {
		sizeRepository.delete(id);
	}
	
	/*public void test() {
		// Delete all sizes
		List<Size> sizes = (List<Size>) findAllSizes();
		for(Size size : sizes) {
			deleteSize(size.getId());
		}
	}*/
}
