package com.example.demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@SpringBootTest
public class CreateEmployee {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	public void test() {
		// 先取得部門
		Department d1 = departmentRepository.findById(1L).get();
		Department d2 = departmentRepository.findById(2L).get();
		Department d3 = departmentRepository.findById(3L).get();
		// 建立員工 
		Employee e1 = new Employee();
		
		
	}
	
}
