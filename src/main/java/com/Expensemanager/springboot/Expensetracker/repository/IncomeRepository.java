package com.Expensemanager.springboot.Expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Expensemanager.springboot.Expensetracker.model.Income;

public interface IncomeRepository extends JpaRepository<Income,Integer>{

}
