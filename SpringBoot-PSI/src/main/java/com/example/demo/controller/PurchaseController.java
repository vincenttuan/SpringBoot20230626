package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Purchase;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.PurchaseItemRepository;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.repository.SupplierRepository;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private PurchaseItemRepository purchaseItemRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	// 採購單主檔 CRUD --------------------------------------------------------
	@GetMapping("/")
	public String index(@ModelAttribute Purchase purchase, Model model) {
		model.addAttribute("purchases", purchaseItemRepository.findAll());
		model.addAttribute("suppliers", supplierRepository.findAll());
		model.addAttribute("employees", employeeRepository.findAll());
		return "purchase";
	}
	
	@PostMapping("/")  // 新增採購單
	public String create(Purchase purchase) {
		purchaseRepository.save(purchase);
		return "redirect:/purchase/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Purchase purchase = purchaseRepository.findById(id).get();
		model.addAttribute("purchase", purchase);
		model.addAttribute("suppliers", supplierRepository.findAll());
		model.addAttribute("employees", employeeRepository.findAll());
		return "purchase-edit";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") Long id, Purchase purchase) {
		purchase.setId(id);
		purchaseRepository.save(purchase);
		return "redirect:/purchase/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		purchaseRepository.deleteById(id);
		return "redirect:/purchase/";
	}
	
	// 採購單明細檔 CRUD --------------------------------------------------------
	
}








