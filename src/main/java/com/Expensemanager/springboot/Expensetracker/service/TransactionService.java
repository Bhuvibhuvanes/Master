package com.Expensemanager.springboot.Expensetracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Expensemanager.springboot.Expensetracker.model.ExpenseManagerNotFoundException;
import com.Expensemanager.springboot.Expensetracker.model.Transaction;
import com.Expensemanager.springboot.Expensetracker.repository.TransactionRepository;

@Service
public class TransactionService {
	  @Autowired
	    private TransactionRepository transactionRepository;

	    public List<Transaction> getTransactions() {
	        List<Transaction> transactions = transactionRepository.findAll();
	        return transactions;
	    }

	    public Transaction getTransactionById(int id) {
	        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
	        if (optionalTransaction.isPresent()) {
	            return optionalTransaction.get();
	        } else {
	            throw new ExpenseManagerNotFoundException("No record exists with the provided ID.");
	        }
	    }

	    public Transaction createOrUpdateTransaction(Transaction transaction) {
	        Transaction savedTransaction = transactionRepository.save(transaction);
	        return savedTransaction;
	    }

	    public Transaction updatePaymentMode(Transaction transaction, int id) {
	        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
	        if (optionalTransaction.isPresent()) {
	            Transaction existingTransaction = optionalTransaction.get();
	            existingTransaction.setPaymentMode(transaction.getPaymentMode());
	            transactionRepository.save(existingTransaction);
	            return existingTransaction;
	        } else {
	            throw new ExpenseManagerNotFoundException("No record exists with the provided ID.");
	        }
	    }

	    public void deleteTransaction(int id) {
	        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
	        if (optionalTransaction.isPresent()) {
	            transactionRepository.deleteById(id);
	        } else {
	            throw new ExpenseManagerNotFoundException("No record exists with the provided ID.");
	        }
	    }
}
