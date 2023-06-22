package com.Expensemanager.springboot.Expensetracker.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Transaction {
	@Id
	private int transactionid;
	private Date date;
	@OneToOne(mappedBy = "transaction")
	private Category category;
	@OneToOne
	@JoinColumn(name = "income_id")
	private Income income;
	

	public Transaction(int transactionid, Date date, Category category, Income income, long amount,
			String description) {
		super();
		this.transactionid = transactionid;
		this.date = date;
		this.category = category;
		this.income = income;
		Amount = amount;
		this.description = description;
	}

	public Transaction() {
		super();
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	
	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	private long Amount;
	private String description;

	public int getTransaction_id() {
		return transactionid;
	}

	public void setTransaction_id(int transaction_id) {
		this.transactionid = transaction_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getAmount() {
		return Amount;
	}

	public void setAmount(long amount) {
		Amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
