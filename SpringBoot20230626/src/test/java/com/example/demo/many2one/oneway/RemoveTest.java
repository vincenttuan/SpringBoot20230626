package com.example.demo.many2one.oneway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class RemoveTest {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void test() {
		// 可否直接刪除"一"的一方 
		// 若要直接刪除"一"的一方, 必須先將多的一方刪除 
		// 若我要刪除 Tom(一方), 就必須先將與 Tom 有關的 order(多方) 先刪除
		orderRepository.deleteById(1L); // 多方
		orderRepository.deleteById(2L); // 多方
		customerRepository.deleteById(1L); // 一方
		
		System.out.println("OK");
	}
	
}
