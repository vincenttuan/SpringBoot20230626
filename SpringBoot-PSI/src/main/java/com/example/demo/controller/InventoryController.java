package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.ProductRepository;

// 即時庫存資訊
@Controller
@RequestMapping("/inventory")
public class InventoryController {
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("inventories", productRepository.queryInventory());
		return "inventory";
	}
	
}
