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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//因為 MySQL 不可以建立 Order 資料表 (因 Order 在 MySQL 中是保留字)
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 訂單序號
	
	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	// 計算訂單總價
	public Integer getTotal() {
		if(orderItems.size() == 0) {
			return 0;
		}
		return orderItems.stream()
				.mapToInt(item -> item.getAmount() * item.getProduct().getPrice())
				.sum();
	}
}
