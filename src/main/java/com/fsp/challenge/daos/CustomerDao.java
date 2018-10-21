package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fsp.challenge.entities.Customer;
import com.fsp.challenge.repositories.CustomerRepository;


@RestController
public class CustomerDao {
	@Autowired
	CustomerRepository customerRepository;

	@PostMapping("/api/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	@GetMapping("/api/customer")
	public Iterable<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/api/customer/{customerId}")
	public Customer findCustomerById(
			@PathVariable("customerId") int id) {
		return customerRepository.findOne(id);
	}

	@PutMapping("/api/customer/{customerId}")
	public Customer updateCustomer(
			@PathVariable("customerId") int id,
			@RequestBody Customer newCustomer) {
		Customer customer = customerRepository.findOne(id);
		customer.set(newCustomer);
		return customerRepository.save(customer);
	}
	
	@DeleteMapping("/api/customer/{customerId}")
	public void deleteCustomer
	(@PathVariable("customerId") int id) {
		customerRepository.delete(id);
	}
	
	/*public void test() {
		// Delete all customers
		List<Customer> customers = (List<Customer>) findAllCustomers();
		for(Customer customer : customers) {
			deleteCustomer(customer.getId());
		}
	}*/
}
