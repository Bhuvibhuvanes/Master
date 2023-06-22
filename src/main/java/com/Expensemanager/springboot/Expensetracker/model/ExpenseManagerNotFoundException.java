package com.Expensemanager.springboot.Expensetracker.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExpenseManagerNotFoundException extends RuntimeException{
	public ExpenseManagerNotFoundException(String exception) {
		super();
	}
	public ExpenseManagerNotFoundException(String exception,Throwable t) {
		super();
	}

}
