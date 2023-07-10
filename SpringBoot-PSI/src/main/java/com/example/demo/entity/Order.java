package com.example.demo.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
//因為 MySQL 不可以建立 Order 資料表 (因 Order 在 MySQL 中是保留字)
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 訂單序號
	
	@Column
	private Date data; // 訂單日期
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer; // 客戶
	
	@OneToMany(mappedBy = "order")
	@OrderBy("id ASC")
	private Set<OrderItem> orderItems = new LinkedHashSet<>(); // 訂單明細s
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee; // 員工
}
