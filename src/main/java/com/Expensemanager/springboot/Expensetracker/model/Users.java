package com.Expensemanager.springboot.Expensetracker.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	private int id;
	private String name;
	private String password;
	
	 
	public Users() {
		super();
	}
	public Users(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
