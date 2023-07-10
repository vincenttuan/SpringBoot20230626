package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_item")
public class PurchaseItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 採購明細序號
	
	@Column
	private Integer amount; // 採購數量
	
	@ManyToOne
	@JoinColumn(name = "purchase_id")
	private Purchase purchase; // 採購單
	
	@ManyToOne
	@JoinColumn(name = "purchase_id")
	private Product product; // 商品 
	
}
