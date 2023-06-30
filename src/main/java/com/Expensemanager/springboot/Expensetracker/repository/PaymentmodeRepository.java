package com.Expensemanager.springboot.Expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Expensemanager.springboot.Expensetracker.model.PaymentMode;


public interface PaymentmodeRepository extends JpaRepository<PaymentMode,Integer>{

}
