package com.example.demo.one2many.oneway;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.oneway.Infect;
import com.example.demo.repository.InfectRepository;

@SpringBootTest
public class QueryTest1 {
	@Autowired
	InfectRepository infectRepository;
	
	@Test
	void test() {
		Infect infect = infectRepository.findById(1L).get();
		System.out.println(infect.getId());
		System.out.println(infect.getName());
		
		// 請測試並觀察 SQL
		// @OneToMany(cascade = {CascadeType.PERSIST})
		// @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
		System.out.println(infect.getVaccines());
	}
}
