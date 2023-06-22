package com.Expensemanager.springboot.Expensetracker.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Income {
	@Id
	private int income_id;
	private Date date;
	private String sourceid;
	private long amount;
	private String description;
	 @OneToOne(mappedBy = "income")
	    private Transaction transaction;
	
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSourceid() {
		return sourceid;
	}

	public void setSource(String sourceid) {
		this.sourceid = sourceid;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIncome_id() {
		return income_id;
	}

	public void setIncome_id(int income_id) {
		this.income_id = income_id;
	}

	public Income(int income_id, Date date, String sourceid, long amount, String description, Transaction transaction) {
		super();
		this.income_id = income_id;
		this.date = date;
		this.sourceid = sourceid;
		this.amount = amount;
		this.description = description;
		this.transaction = transaction;
	}

	public Income() {
		super();
	}



}
