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
	    public ResponseEntity<List<Transaction>> getTransactions() {
	        List<Transaction> transactions = transactionService.getTransactions();
	        return new ResponseEntity<>(transactions, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") int id) {
	        Transaction transaction = transactionService.getTransactionById(id);
	        return new ResponseEntity<>(transaction, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Transaction> createOrUpdateTransaction(@RequestBody Transaction transaction) {
	        Transaction savedTransaction = transactionService.createOrUpdateTransaction(transaction);
	        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction,
	                                                         @PathVariable("id") int id) {
	        transaction.setId(id);
	        Transaction updatedTransaction = transactionService.createOrUpdateTransaction(transaction);
	        return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTransaction(@PathVariable("id") int id) {
	        transactionService.deleteTransaction(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
