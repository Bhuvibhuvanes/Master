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

import com.Expensemanager.springboot.Expensetracker.model.Transaction;
import com.Expensemanager.springboot.Expensetracker.service.TransactionService;

@RestController
@ControllerAdvice
@RequestMapping("/transactions")
public class TransactionController extends ResponseEntityExceptionHandler {
	@Autowired
	TransactionService transactionService;

	@GetMapping
	public ResponseEntity<List<Transaction>> getTransaction() {
		List<Transaction> list = transactionService.getTransaction();
		return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transaction> getTransactionId(@PathVariable("id") int id) {
		Transaction entity = transactionService.getTransactionId(id);
		return new ResponseEntity<Transaction>(entity, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Transaction> createOrUpdatetransaction(@RequestBody Transaction transaction) {
		Transaction update = transactionService.createOrUpdateTransaction(transaction);
		return new ResponseEntity<Transaction>(update, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Transaction> updatetransactiont(@RequestBody Transaction transaction, @PathVariable int id) {
		Transaction entity = transactionService.updateTransaction(transaction, id);
		return new ResponseEntity<Transaction>(entity, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deletetransaction(@PathVariable("id") int id) {
		transactionService.deleteTransaction(id);
		return HttpStatus.OK;
	}
}
