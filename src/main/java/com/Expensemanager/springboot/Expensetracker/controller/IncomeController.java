package com.Expensemanager.springboot.Expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Expensemanager.springboot.Expensetracker.model.Users;
import com.Expensemanager.springboot.Expensetracker.model.Income;
import com.Expensemanager.springboot.Expensetracker.service.IncomService;

@RestController
@ControllerAdvice
@RequestMapping("/incomes")
public class IncomeController {
	@Autowired
	IncomService incomeService;

	@GetMapping
	public ResponseEntity<List<Income>> getIncome() {
		List<Income> list = incomeService.getIncome();
		return new ResponseEntity<List<Income>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Income> getIncomeId(@PathVariable("id") int id) {
		Income entity = incomeService.getIncomeId(id);
		return new ResponseEntity<Income>(entity, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Income> createOrUpdateIncome(@RequestBody Income income) {
		Income entity = incomeService.createOrUpdateIncome(income);
		return new ResponseEntity<Income>(entity, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Income> updateIncome(@RequestBody Income income, @PathVariable int id) {
		Income entity = incomeService.updateIncome(income, id);
		return new ResponseEntity<Income>(entity, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteIncome(@PathVariable("id") int id) {
		incomeService.deleteIncome(id);
		return HttpStatus.OK;
	}

}
