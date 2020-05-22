package com.codejek.product.catalog.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codejek.product.catalog.management.entity.CategoryEntity;
import com.codejek.product.catalog.management.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public CategoryEntity create(CategoryEntity categoryEntity) {
		
		return categoryRepository.save(categoryEntity);
	}

	@Override
	public CategoryEntity update(CategoryEntity categoryEntity) {
		
		return categoryRepository.save(categoryEntity);
	}
	
	@Override
	public CategoryEntity get(long id) {
		
		return categoryRepository.getOne(id);
	}

	@Override
	public List<CategoryEntity> getAll() {
		
		return categoryRepository.findAll();
	}

	@Override
	public void delete(CategoryEntity categoryEntity) {
		
		categoryRepository.delete(categoryEntity);
	}

	@Override
	public List<CategoryEntity> getAllCatBySupCat(long supCatId) {
		
		return categoryRepository.findAllCatBySupCat(supCatId);
	}
}
