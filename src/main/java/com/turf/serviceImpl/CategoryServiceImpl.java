package com.turf.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turf.enities.Category;
import com.turf.repository.CategoryRepository;
import com.turf.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {

		return categoryRepository.save(category);
	}

	@Override
	public boolean existsByName(String name) {

		return categoryRepository.existsByName(name);
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}

	@Override
	public Category getCategoryById(int id) {
		Category category = categoryRepository.findById(id).orElse(null);
		return category;
	}

	@Override
	public List<Category> getAllActiveCategory() {
		
		List<Category> categories = categoryRepository.findByIsActiveTrue();

		return categories;
	}

	@Override
	public boolean deleteCategory(int id) {
		
		return false;
	}

	

}
