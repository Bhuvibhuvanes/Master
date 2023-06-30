package com.Expensemanager.springboot.Expensetracker.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Category {
	@Id
//	@OneToOne(cascade = CascadeType.ALL)
	private int id;
	
	private String categorys;
	
	public Category(int id, String categorys) {
		super();
		this.id = id;
		this.categorys = categorys;
	}
	public Category() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategorys() {
		return categorys;
	}
	public void setCategorys(String categorys) {
		this.categorys = categorys;
	}

}
