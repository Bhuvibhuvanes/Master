package com.Expensemanager.springboot.Expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Expensemanager.springboot.Expensetracker.model.Category;
import com.Expensemanager.springboot.Expensetracker.service.CategoryService;

@RestController
@ControllerAdvice
@RequestMapping("/categorys")
public class CategoryController  extends ResponseEntityExceptionHandler {
	 @Autowired
	    CategoryService categoryService;

	    @GetMapping
	    public ResponseEntity<List<Category>> getCategory() {
	        List<Category> categories = categoryService.getCategory();
	        return new ResponseEntity<>(categories, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {
	        Category category = categoryService.getCategoryId(id);
	        return new ResponseEntity<>(category, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Category> createOrUpdateCategory(@RequestBody Category category) {
	        Category updatedCategory = categoryService.createOrUpdateCategory(category);
	        return new ResponseEntity<>(updatedCategory, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable("id") int id) {
	        category.setId(id);
	        Category updatedCategory = categoryService.createOrUpdateCategory(category);
	        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCategory(@PathVariable("id") int id) {
	        categoryService.deleteCategory(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
