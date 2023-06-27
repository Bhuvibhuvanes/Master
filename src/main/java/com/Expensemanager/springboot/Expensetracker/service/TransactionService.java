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
	TransactionRepository transactionRepository;


	public List<Transaction> getTransaction() {
		List<Transaction> transaction = transactionRepository.findAll();
		if (transaction.size() > 0) {
			return transaction;
		} else {
			return new ArrayList<Transaction>();
		}

	}

	public Transaction getTransactionId(int id) {
		Optional<Transaction> transaction = transactionRepository.findById(id);
		if (transaction.isPresent()) {
			return transaction.get();
		} else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}
	public Transaction updateTransaction(Transaction transaction,int id) {
		Optional<Transaction> transactions=transactionRepository.findById(id);
		if(transactions.isPresent()) {
			Transaction newTransaction=transactions.get();
			newTransaction.getAmount();
			newTransaction.getDate();
			newTransaction.getCasHand();
			newTransaction.getLiquidAmount();
			newTransaction.getDescription();
			newTransaction.getTransactionid();
			newTransaction=transactionRepository.save(newTransaction);
			return newTransaction;
		}else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}
	public Transaction createOrUpdateTransaction(Transaction transaction) {
		Optional<Transaction> transactions=transactionRepository.findById(transaction.getTransactionid());
		if(transactions.isPresent()) {
			Transaction newTransaction=transactions.get();
			newTransaction.getTransactionid();
			newTransaction.getAmount();
			newTransaction.getDate();
			newTransaction.getCasHand();
			newTransaction.getLiquidAmount();
			newTransaction.getDescription();
			newTransaction=transactionRepository.save(newTransaction);
			return newTransaction;
		}
			else {
				transaction=transactionRepository.save(transaction);
				return transaction;
			}
	}
	public void  deleteTransaction(int id) {
		Optional<Transaction> transaction=transactionRepository.findById(id);
		if(transaction.isPresent()) {
			transactionRepository.deleteById(id);
			
		}else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}

}
