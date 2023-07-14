package com.example.demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class QueryOrder {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void test() {
		// 查詢所有訂單與明細
		// 訂單id, 客戶姓名, 員工姓名, 總價, (主檔)
		// 明細id, 商品名稱, 數量, 單價, 小計 (明細)
		
	}
}
