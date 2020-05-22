package com.codejek.product.catalog.management.service;

import java.util.List;

import com.codejek.product.catalog.management.entity.SuperCategoryEntity;

public interface SuperCategoryService {

	public SuperCategoryEntity create(SuperCategoryEntity superCategoryEntity);
	public SuperCategoryEntity update(SuperCategoryEntity superCategoryEntity);
	public SuperCategoryEntity get(long id);
	public List<SuperCategoryEntity> getAll();
	public void delete(SuperCategoryEntity superCategoryEntity);
}
