package com.example.demo.one2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2one.Manager;
import com.example.demo.repository.ManagerRepository;

@SpringBootTest
public class CreateManager {
	@Autowired
	ManagerRepository managerRepository;
	
	@Test
	void test() {
		Manager manager = new Manager();
		manager.setName("John");
		
		managerRepository.save(manager);
		
		System.out.println("OK");
		
	}
	
}
