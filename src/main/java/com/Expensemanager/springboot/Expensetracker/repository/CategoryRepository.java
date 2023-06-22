package com.Expensemanager.springboot.Expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Expensemanager.springboot.Expensetracker.model.Category;


public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
