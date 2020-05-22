package com.codejek.product.catalog.management.service;

import java.util.List;

import com.codejek.product.catalog.management.entity.CategoryEntity;

public interface CategoryService {

	public CategoryEntity create(CategoryEntity categoryEntity);
	public CategoryEntity update(CategoryEntity categoryEntity);
	public CategoryEntity get(long id);
	public List<CategoryEntity> getAll();
	public void delete(CategoryEntity categoryEntity);
	public List<CategoryEntity> getAllCatBySupCat(long supCatId);
}
