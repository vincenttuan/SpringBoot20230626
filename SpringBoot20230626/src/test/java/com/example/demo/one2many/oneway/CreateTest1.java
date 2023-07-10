package com.example.demo.one2many.oneway;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.oneway.Infect;
import com.example.demo.entity.one2many.oneway.Vaccine;
import com.example.demo.repository.InfectRepository;
import com.example.demo.repository.VaccineRepository;

@SpringBootTest
public class CreateTest1 {
	
	@Autowired
	InfectRepository infectRepository;
	
	@Autowired
	VaccineRepository vaccineRepository;
	
	@Test
	void test() {
		// 傳染病: COVID-19 
		// 疫苗: AZ 打 3 劑
		// 疫苗: BNT 打 2 劑 
		// 疫苗: PJ(嬌生) 打 1 劑
		
		Infect infect = new Infect();
		infect.setName("COVID-19");
		
		Vaccine v1 = new Vaccine();
		v1.setName("AZ");
		v1.setCount(3);
		
		Vaccine v2 = new Vaccine();
		v2.setName("BNT");
		v2.setCount(2);
		
		Vaccine v3 = new Vaccine();
		v3.setName("PJ");
		v3.setCount(1);
		
		// 設置關聯關係
		infect.getVaccines().add(v1);
		infect.getVaccines().add(v2);
		infect.getVaccines().add(v3);
		
		// 非聯集關聯的操作 
		// @OneToMany 是由 "1" 的一方來維護 "多" 的一方的關聯欄位(infect_id), 所以會多增加 update 語句
		// 先新增疫苗
		//vaccineRepository.save(v1);
		//vaccineRepository.save(v2);
		//vaccineRepository.save(v3);
		// 再新增傳染病
		//infectRepository.save(infect);
		
		// 聯集關聯的操作
		// @OneToMany(cascade = {CascadeType.PERSIST})
		// 表示只要新增 infect, 剩餘的 v1, v2, v3 會自動新增
		infectRepository.save(infect);
		
		System.out.println("OK");
	}
}
