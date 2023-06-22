package com.Expensemanager.springboot.Expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Expensemanager.springboot.Expensetracker.model.Users;


public interface UserRepository extends JpaRepository<Users,Integer> {

}
