package com.example.demo.one2one;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2one.Department;
import com.example.demo.entity.one2one.Manager;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ManagerRepository;

@SpringBootTest
public class CreateTest2 {
	// 在既有的 department 與 employee 資料上建立關聯
	// 例如: IT 部門沒有 manager 關聯
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Test
	void test() {
		// 取得 IT 部門
		Optional<Department> optDept = departmentRepository.findById(2L);
		if(optDept.isPresent()) {
			// 取得 John 經理
			Optional<Manager> optMgr = managerRepository.findById(2L);
			if(optMgr.isPresent()) {
				// 建立關聯
				Department department = optDept.get();
				Manager manager = optMgr.get();
				department.setManager(manager);
				// 儲存
				departmentRepository.save(department);
				System.out.println("OK");
				
			} else {
				System.out.println("查無此人");
			}
			
		} else {
			System.out.println("無此部門");
		}
	}
}
