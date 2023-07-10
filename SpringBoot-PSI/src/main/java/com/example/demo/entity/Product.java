package com.example.demo.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 商品序號
	
	@Column
	private String name; // 商品名稱
	
	@Column
	private Integer cost; // 成本
	
	@Column
	private Integer price; // 定價/售價
	
	@OneToMany(mappedBy = "product")
	@OrderBy("id ASC")
	private Set<PurchaseItem> purchaseItems = new LinkedHashSet<>(); // 採購單明細s
	
	@OneToMany(mappedBy = "product")
	@OrderBy("id ASC")
	private Set<OrderItem> orderItems = new LinkedHashSet<>(); // 訂單明細s
	
	
}
