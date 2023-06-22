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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Expensemanager.springboot.Expensetracker.model.Users;
import com.Expensemanager.springboot.Expensetracker.model.Transaction;
import com.Expensemanager.springboot.Expensetracker.service.UserService;

@RestController
@ControllerAdvice
@RequestMapping("/users")
public class UserController extends ResponseEntityExceptionHandler {
	@Autowired
	UserService expenseService;

	@GetMapping
	public ResponseEntity<List<Users>> getExpense() {
		List<Users> list = expenseService.getExpenset();

		return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Users> getExpenseId(@PathVariable("id") int id) {
		Users entity = expenseService.getExpenseId(id);
		return new ResponseEntity<Users>(entity, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Users> createOrUpdateExpense(@RequestBody Users expense) {
		Users entity = expenseService.createOrUpdateExpense(expense);
		return new ResponseEntity<Users>(entity, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Users> updateExpense(@RequestBody Users expense, @PathVariable int id) {
		Users entity = expenseService.updateExpense(expense, id);
		return new ResponseEntity<Users>(entity, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteExpense(@PathVariable("id") int id) {
		expenseService.deleteExpense(id);
		return HttpStatus.OK;
	}

}
