package com.fsp.challenge.daos;

import java.util.Date;

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
import com.fsp.challenge.entities.Store;
import com.fsp.challenge.entities.pizza.Pizza;
import com.fsp.challenge.entities.pizza.Promo;
import com.fsp.challenge.repositories.CustomerRepository;
import com.fsp.challenge.repositories.OrderRepository;
import com.fsp.challenge.repositories.PizzaRepository;
import com.fsp.challenge.repositories.PromoRepository;
import com.fsp.challenge.repositories.StoreRepository;

@RestController
public class OrderDao {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	PizzaRepository pizzaRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	StoreRepository storeRepository;
	@Autowired
	PromoRepository promoRepository;
	
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
	
	@PutMapping("/api/order/{orderId}/promo/{code}")
	public PizzaOrder addPromo(
			@PathVariable("orderId") int id,
			@PathVariable("code") String code) {
		PizzaOrder order = orderRepository.findOne(id);
		Promo promo = promoRepository.find(code);
		Date today = new Date();
		if(promo != null && promo.getStore() == order.getStore() && promo.getUsed() == 0) {// && promo.getExpiration().before(today) && promo.getDiscountPercent() > 0 && promo.getDiscountPercent() < 101) {
			double promoPrice = order.getTotalPrice() - ((promo.getDiscountPercent() / 100) * order.getTotalPrice());
			order.setTotalPrice(promoPrice);
			promo.setUsed(1);
			promoRepository.save(promo);
		}
		return orderRepository.save(order);
	}
	
	@PutMapping("/api/order/{orderId}/store/{sid}/customer/{cid}/pizza/{pid}")
	public PizzaOrder buildOrder(
			@PathVariable("orderId") int id,
			@PathVariable("sid") int sid,
			@PathVariable("cid") int cid,
			@PathVariable("pid") int pid) {
		PizzaOrder order = orderRepository.findOne(id);
		Customer c = customerRepository.findOne(cid);
		Store s = storeRepository.findOne(sid);
		Pizza p = pizzaRepository.findOne(pid);
		if(c == null || s == null || p == null || p.getBase() == null || p.getCheese() == null || p.getSauce() == null || p.getSize() == null) {
			orderRepository.delete(id);	// invalid order
			return null;
		}
		order.setCustomer(c);
		order.setStore(s);
		p.setOrder(order);
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
