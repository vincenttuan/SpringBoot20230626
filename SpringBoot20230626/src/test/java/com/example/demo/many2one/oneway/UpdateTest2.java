package com.example.demo.many2one.oneway;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2one.oneway.Customer;
import com.example.demo.entity.many2one.oneway.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class UpdateTest2 {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void test() {
		// 我要將訂單 id = 3 的客戶名稱改成 Helen
		// 透過 Order 得到 Customer
		Order order = orderRepository.findById(3L).get();
		Customer customer = order.getCustomer();
		System.out.println(customer.getName());
		// 客戶名稱改成 Helen
		customer.setName("Helen");
		// 修改方式二: 因為在 Order.java 中有設定 @ManyToOne(cascade = CascadeType.MERGE) 聯級修改
		// 所以可以藉由儲存 order 去影響到 customer 的內容 (聯級修改)
		orderRepository.save(order);
		
		System.out.println("OK");
	}
	
}
