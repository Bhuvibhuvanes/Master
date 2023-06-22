package com.Expensemanager.springboot.Expensetracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Expensemanager.springboot.Expensetracker.model.Category;
import com.Expensemanager.springboot.Expensetracker.model.ExpenseManagerNotFoundException;
import com.Expensemanager.springboot.Expensetracker.model.Transaction;
import com.Expensemanager.springboot.Expensetracker.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getCategory() {

		List<Category> category = categoryRepository.findAll();
		if (category.size() > 0) {
			return category;
		} else {
			return new ArrayList<Category>();
		}
	}

	public Category getCategoryId(int id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()) {
			return category.get();
		} else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}

	public Category updateCategory(Category category, int id) {
		Optional<Category> categorys = categoryRepository.findById(id);
		if (categorys.isPresent()) {
			Category newCategory = new Category();
			newCategory.getName();
			return newCategory;
		} else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}
	public Category createOrUpdateCategory(Category category) {
		Optional<Category> categorys=categoryRepository.findById(category.getCategory_id());
		if(categorys.isPresent()) {
		Category newCategory=new Category();
		newCategory.getName();
		newCategory.getCategory_id();
		return newCategory;
		}
		else {
			category=categoryRepository.save(category);
			return category;
		}
	}
	
	public void  deleteCategory(int id) {
		Optional<Category> category=categoryRepository.findById(id);
		if(category.isPresent()) {
			categoryRepository.deleteById(id);
			
		}else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}

	
}
