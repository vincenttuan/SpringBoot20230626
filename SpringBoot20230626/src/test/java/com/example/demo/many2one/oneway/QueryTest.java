package com.example.demo.many2one.oneway;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2one.oneway.Order;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class QueryTest {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void test() {
		// 因為是多對一, 所以預設 fetch = FetchType.EAGER, 查詢時會連同 "1" 的一方一併查出
		// sql 會使用 left outer join
		Order order = orderRepository.findById(1L).get();
		System.out.println("order id      = " + order.getId());
		System.out.println("order name    = " + order.getName());
		System.out.println("customer id   = " + order.getCustomer().getId());
		System.out.println("customer name = " + order.getCustomer().getName());
		
		List<Order> orders = orderRepository.findAll();
		orders.forEach(System.out::println);
		
	}
}
