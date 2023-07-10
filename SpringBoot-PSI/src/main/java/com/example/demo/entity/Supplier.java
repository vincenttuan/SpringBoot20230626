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
@Table(name = "supplier")
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 供應商序號
	
	@Column
	private String name; // 供應商名稱
	
	@OneToMany(mappedBy = "supplier")
	@OrderBy("id ASC")
	private Set<Purchase> purchases = new LinkedHashSet<>();
	
}
