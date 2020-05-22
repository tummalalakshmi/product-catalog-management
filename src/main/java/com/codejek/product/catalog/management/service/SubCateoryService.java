package com.codejek.product.catalog.management.service;

import java.util.List;

import com.codejek.product.catalog.management.entity.SubCategoryEntity;

public interface SubCateoryService {

	public SubCategoryEntity create(SubCategoryEntity subCategoryEntity);
	public SubCategoryEntity update(SubCategoryEntity subCategoryEntity);
	public SubCategoryEntity get(long id);
	public List<SubCategoryEntity> getAll();
	void delete(SubCategoryEntity subCategoryEntity);
	SubCategoryEntity getByName(String name);
	List<SubCategoryEntity> findAllSubCatByCat(long catId);
}
