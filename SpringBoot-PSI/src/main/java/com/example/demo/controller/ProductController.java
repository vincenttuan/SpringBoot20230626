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

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/")
	public String index(@ModelAttribute Product product, Model model) {
		model.addAttribute("products", productRepository.findAll());
		return "product";
	}
	
	@PostMapping("/")
	public String create(Product product) {
		productRepository.save(product);
		return "redirect:/product/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Product product = productRepository.findById(id).get();
		model.addAttribute("product", product);
		return "product-edit";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") Long id, Product product) {
		product.setId(id);
		productRepository.save(product);
		return "redirect:/product/";
	}
	
	@GetMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		productRepository.deleteById(id);
		return "redirect:/product/";
	}
}
