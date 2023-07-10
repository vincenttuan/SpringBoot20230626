package com.example.demo.many2one.oneway;

import javax.persistence.CascadeType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.many2one.oneway.Customer;
import com.example.demo.entity.many2one.oneway.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class CreateTest {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void test() {
		// 建立 entity 物件
		/*
		Customer c1 = new Customer("John");
		Order o1 = new Order("A-1");
		Order o2 = new Order("B-2");
		*/
		Customer c1 = new Customer("Mary");
		Order o1 = new Order("C-3");
		Order o2 = new Order("D-4");
		
		// 設定關聯關係(讓"多"方記住"一"方)
		o1.setCustomer(c1);
		o2.setCustomer(c1);
		
		// 單向多對一
		// 先保存 "一" 的一方再保存 "多" 的一方
		// 前提 (cascade = CascadeType.MERGE)
		customerRepository.save(c1);
		orderRepository.save(o1);
		orderRepository.save(o2);
		
		System.out.println("OK");
		
	}
}
