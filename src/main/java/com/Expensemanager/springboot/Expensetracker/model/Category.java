package com.Expensemanager.springboot.Expensetracker.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Category {
	@Id
	private int category_id;
	private String name;
	 @OneToOne(cascade = CascadeType.ALL)
	private Transaction transaction;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category(int category_id, String name, Transaction transaction) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.transaction = transaction;
	}

	public Category() {
		super();
	}

}
