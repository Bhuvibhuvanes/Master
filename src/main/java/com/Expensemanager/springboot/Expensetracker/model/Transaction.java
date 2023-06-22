package com.Expensemanager.springboot.Expensetracker.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Transaction {
	@Id
	private int transactionid;
	private Date date;
	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	private long Amount;
	private String description;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "income_id")
	private Income income;
//	private long cash;
//	private long liquidCash;

	public Transaction(int transactionid, Date date, Category category, long amount, String description, Income income,
			long cash, long liquidCash) {
		super();
		this.transactionid = transactionid;
		this.date = date;
		this.category = category;
		Amount = amount;
		this.description = description;
		this.income = income;
//		this.cash = cash;
//		this.liquidCash = liquidCash;
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

	

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

//	public long getCash() {
//		return cash;
//	}
//
//	public void setCash(long cash) {
//		this.cash = cash;
//	}
//
//	public long getLiquidCash() {
//		return liquidCash;
//	}
//
//	public void setLiquidCash(long liquidCash) {
//		this.liquidCash = liquidCash;
//	}

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
