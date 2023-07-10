package com.example.demo.entity.one2many.oneway;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// 單向一對多
@Entity
@Table(name = "infect")
public class Infect { // 傳染病
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50, unique = true)
	private String name;
	
	//@OneToMany // 非聯集關聯
	@OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER) // 聯集新增
	@JoinColumn(name = "infect_id")
	private Set<Vaccine> vaccines = new LinkedHashSet();

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

	public Set<Vaccine> getVaccines() {
		return vaccines;
	}

	public void setVaccines(Set<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}
	
	
	
}
