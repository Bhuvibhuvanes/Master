package com.Expensemanager.springboot.Expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Expensemanager.springboot.Expensetracker.model.Transaction;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Integer>{

}
