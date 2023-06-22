package com.Expensemanager.springboot.Expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Expensemanager.springboot.Expensetracker.model.Transaction;

public interface TransactionRepository  extends JpaRepository<Transaction, Integer>{

}
