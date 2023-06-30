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
	private int id;
	private String Description;
	private double amount;
	private String transaction;
	@OneToOne
	@JoinColumn(name = "categorys")
	private Category category;
	@OneToOne
	@JoinColumn(name = "mode")
	private PaymentMode paymentMode;

	public Transaction() {
		super();
	}
	public Transaction(int id, String description, double amount, String transaction, Category category,
			PaymentMode paymentMode) {
		super();
		this.id = id;
		Description = description;
		this.amount = amount;
		this.transaction = transaction;
		this.category = category;
		this.paymentMode = paymentMode;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransaction() {
		return transaction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
}
