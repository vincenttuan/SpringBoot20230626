package com.example.demo.entity.many2one.oneway;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	// 單向多對一
	@JoinColumn(name = "customer_id")
	@ManyToOne(cascade = CascadeType.MERGE)
	/*
	 * CascadeType.PERSIST	在儲存時一併儲存 被參考的物件。
	 * CascadeType.MERGE	在合併修改時一併 合併修改被參考的物件。
	 * CascadeType.REMOVE	在移除時一併移除 被參考的物件。
	 * CascadeType.REFRESH	在更新時一併更新 被參考的物件。
	 * CascadeType.ALL	無論儲存、合併、 更新或移除，一併對被參考物件作出對應動作。
	 * */
	private Customer customer;
	
	public Order() {
		
	}
	
	public Order(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", customer=" + customer + "]";
	}
	
	
	
	
}
