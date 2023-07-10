package com.example.demo.many2one.oneway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2one.oneway.Customer;
import com.example.demo.entity.many2one.oneway.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class UpdateTest {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void test() {
		// 我要將訂單 id = 1 的客戶名稱改成 Tom
		// 透過 Order 得到 Customer
		Order order = orderRepository.findById(1L).get();
		Customer customer = order.getCustomer();
		System.out.println(customer.getName());
		// 客戶名稱改成 Tom
		customer.setName("Tom");
		// 修改方式一: 正常方式
		customerRepository.save(customer);
		
		System.out.println("OK");
	}
	
}
