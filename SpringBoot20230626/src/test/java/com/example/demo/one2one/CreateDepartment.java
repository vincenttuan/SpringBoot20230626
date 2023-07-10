package com.example.demo.one2one;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2one.Department;
import com.example.demo.repository.DepartmentRepository;

@SpringBootTest
public class CreateDepartment {
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Test
	void test() {
		// 建立 Department
		Department department = new Department();
		department.setName("IT");
		
		// 存檔
		departmentRepository.save(department);
		
		System.out.println("OK");
	}
	
	
}
