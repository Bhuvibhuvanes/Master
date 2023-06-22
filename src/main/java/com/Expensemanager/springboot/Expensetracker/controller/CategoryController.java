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
	CategoryService categoryservice;
	@GetMapping
	public ResponseEntity <List<Category>>getCategory(){
		List<Category>list = categoryservice.getCategory();
    	return new ResponseEntity<List<Category>>(list,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Category>getCategoryId(@PathVariable("id")int id){
		Category entity=categoryservice.getCategoryId(id);

		return new ResponseEntity<Category>(entity,HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<Category>createOrUpdateCategory(@RequestBody Category category){

		Category update=categoryservice.createOrUpdateCategory(category);
return new ResponseEntity<Category>(update,HttpStatus.CREATED);		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Category>updateCategroy(@RequestBody Category category,@PathVariable int id)
	{

		Category entity=categoryservice.updateCategory(category,id);
return new ResponseEntity<Category>(HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public HttpStatus deleteCategory(@PathVariable("id")int id) {
		categoryservice.deleteCategory(id);

		return HttpStatus.OK;
	}
}
