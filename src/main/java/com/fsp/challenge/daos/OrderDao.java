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
import com.fsp.challenge.entities.PizzaOrder;
import com.fsp.challenge.entities.pizza.Pizza;
import com.fsp.challenge.repositories.CustomerRepository;
import com.fsp.challenge.repositories.OrderRepository;
import com.fsp.challenge.repositories.PizzaRepository;

@RestController
public class OrderDao {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	PizzaRepository pizzaRepository;
	@Autowired
	CustomerRepository customerRepository;

	@PostMapping("/api/order")
	public PizzaOrder createOrder(@RequestBody PizzaOrder order) {
		return orderRepository.save(order);
	}
	
	@GetMapping("/api/order")
	public Iterable<PizzaOrder> findAllOrders() {
		return orderRepository.findAll();
	}
	
	@GetMapping("/api/order/{orderId}")
	public PizzaOrder findOrderById(
			@PathVariable("orderId") int id) {
		return orderRepository.findOne(id);
	}

	@PutMapping("/api/order/{orderId}")
	public PizzaOrder updateOrder(
			@PathVariable("orderId") int id,
			@RequestBody PizzaOrder newOrder) {
		PizzaOrder order = orderRepository.findOne(id);
		order.set(newOrder);
		return orderRepository.save(order);
	}
	
	@PutMapping("/api/order/{orderId}/customer/{cid}/pizza/{pid}")
	public PizzaOrder buildOrder(
			@PathVariable("orderId") int id,
			@PathVariable("cid") int cid,
			@PathVariable("pid") int pid) {
		PizzaOrder order = orderRepository.findOne(id);
		Customer c = customerRepository.findOne(cid);
		Pizza p = pizzaRepository.findOne(pid);
		order.setCustomer(c);
		order.addPizza(p);
		return orderRepository.save(order);
	}
	
	@DeleteMapping("/api/order/{orderId}")
	public void deleteOrder
	(@PathVariable("orderId") int id) {
		orderRepository.delete(id);
	}
	
	/*public void test() {
		// Delete all orders
		List<Order> orders = (List<Order>) findAllOrders();
		for(Order order : orders) {
			deleteOrder(order.getId());
		}
	}*/
}
