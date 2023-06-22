package com.Expensemanager.springboot.Expensetracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Expensemanager.springboot.Expensetracker.model.Users;
import com.Expensemanager.springboot.Expensetracker.model.ExpenseManagerNotFoundException;
import com.Expensemanager.springboot.Expensetracker.model.Transaction;
import com.Expensemanager.springboot.Expensetracker.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<Users> getExpenset() {
		List<Users> expense=userRepository.findAll();
		if(expense.size()>0) {
			return expense;
		}else
		{
			return new ArrayList<Users>();
		}
		
	}
	public Users getExpenseId(int id) {
		Optional<Users> expense=userRepository.findById(id);
		if(expense.isPresent()) {
			return expense.get();
		}else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}
	public Users updateExpense(Users user,int id) {
		Optional<Users> expenses=userRepository.findById(user.getId());
		if(expenses.isPresent()) {
			Users newExpense=new Users();
			newExpense.getName();
			newExpense.getPassword();
			
			userRepository.save(newExpense);
			return newExpense;
		}else {
			throw new ExpenseManagerNotFoundException("No record Exist");

		}
	}
	public Users createOrUpdateExpense(Users user) {
		Optional<Users> expenses=userRepository.findById(user.getId());
		if(expenses.isPresent()) {
			Users newExpenses=expenses.get();
			newExpenses.getName();
			newExpenses.getPassword();
			newExpenses.getId();
			newExpenses=userRepository.save(newExpenses);
			return newExpenses;
		}else {
			user=userRepository.save(user);
			return user;
		}
	}
	public void  deleteExpense(int id) {
		Optional<Users> transaction=userRepository.findById(id);
		if(transaction.isPresent()) {
			userRepository.deleteById(id);
			
		}else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}

}
