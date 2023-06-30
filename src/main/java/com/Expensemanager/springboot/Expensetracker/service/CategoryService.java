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
		List<Category> cat = categoryRepository.findAll();
		if (cat.size() > 0) {
			return cat;
		} else {
			return new ArrayList<Category>();
		}
	}
	public Category getCategoryId(int id) {
		Optional<Category> cat = categoryRepository.findById(id);
		if (cat.isPresent()) {
			return cat.get();
		} else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}
	public Category createOrUpdateCategory(Category category) {
		Optional<Category> cats = categoryRepository.findById(category.getId());
		if (cats.isPresent()) {
			Category newCat = new Category();
			newCat.getCategorys();
			newCat.getId();
			categoryRepository.save(newCat);
			return category;
		} else {
			return categoryRepository.save(category);	
		}
	}
	public Category updateCategory(Category category, int id) {
		Optional<Category> cats = categoryRepository.findById(id);
		if (cats.isPresent()) {
			Category newCat = new Category();
			newCat.getCategorys();
			categoryRepository.save(newCat);
			return category;
		} else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}
	public void deleteCategory(int id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()) {
			categoryRepository.deleteById(id);
		} else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}
}
