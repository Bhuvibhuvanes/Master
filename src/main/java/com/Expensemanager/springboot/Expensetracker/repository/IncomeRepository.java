package com.Expensemanager.springboot.Expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Expensemanager.springboot.Expensetracker.model.Income;
@Repository
public interface IncomeRepository extends JpaRepository<Income,Integer>{

}
