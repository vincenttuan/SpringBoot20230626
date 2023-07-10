package com.example.demo.one2many.twoway;

import javax.persistence.OneToMany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.one2many.twoway.MenuGroup;
import com.example.demo.entity.one2many.twoway.MenuItem;
import com.example.demo.repository.MenuGroupRepository;
import com.example.demo.repository.MenuItemRepository;

@SpringBootTest
public class CreateTest1 {
	@Autowired
	MenuGroupRepository menuGroupRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Test
	void test() {
		MenuGroup group1 = new MenuGroup("一號餐");
		MenuItem item1 = new MenuItem("可樂", 20);
		MenuItem item2 = new MenuItem("漢堡", 40);
		
		// 設置關聯關係
		// 因為在 1 的一方 @OneToMany(mappedBy = "menuGroup")
		// 所以以下二行不用設定
		//group1.getItems().add(item1); // BUT 聯集操作此行要加入
		//group1.getItems().add(item2); // BUT 聯集操作此行要加入
		item1.setMenuGroup(group1);
		item2.setMenuGroup(group1);
		
		// 非聯集操作下(無使用 CascadeType 的設定)
		// @OneToMany 
		// @ManyToOne
		// 執行保存操作(先存"一"的一方, 再存"多"的一方)
		menuGroupRepository.save(group1);
		menuItemRepository.save(item1);
		menuItemRepository.save(item2);
		
		// 聯集操作
		//menuGroupRepository.save(group1);
		
		System.out.println("OK");
	}
}
