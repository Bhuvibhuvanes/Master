package com.Expensemanager.springboot.Expensetracker.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Expensemanager.springboot.Expensetracker.model.Users;
import com.Expensemanager.springboot.Expensetracker.model.ExpenseManagerNotFoundException;
import com.Expensemanager.springboot.Expensetracker.model.Income;
import com.Expensemanager.springboot.Expensetracker.repository.IncomeRepository;

@Service
public class IncomService {
	@Autowired
	IncomeRepository incomeRepository;
	public List<Income> getIncome(){
		List<Income> income=incomeRepository.findAll();
		if(income.size()>0) {
			return income;
		}else {
			return new ArrayList<Income>();
		}
		
	}
	public Income getIncomeId(int id){
		Optional<Income> income=incomeRepository.findById(id);
		if(income.isPresent()) {
			return income.get();
		}else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}
	public Income createOrUpdateIncome(Income income) {
		Optional<Income> incomes=incomeRepository.findById(income.getIncome_id());
		if(incomes.isPresent()) {
		Income newIncome=incomes.get();
	
		newIncome.getAmount();
		newIncome.getDate();
		newIncome.getDescription();
		newIncome.getIncome_id();
		incomeRepository.save(newIncome);
		return income;
		}else {
			return incomeRepository.save(income);

		}
		
	}
	public Income updateIncome(Income income,int id) {
		Optional<Income> incomes=incomeRepository.findById(income.getIncome_id());
		if(incomes.isPresent()) {
			Income newincome=new Income();
			newincome.getAmount();
			newincome.getDate();
			newincome.getDescription();
			
			incomeRepository.save(newincome);
			return newincome;
		}else {
			throw new ExpenseManagerNotFoundException("No record Exist");

		}
	}
	public void  deleteIncome(int id) {
		Optional<Income> transaction=incomeRepository.findById(id);
		if(transaction.isPresent()) {
			incomeRepository.deleteById(id);
			
		}else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}

}
