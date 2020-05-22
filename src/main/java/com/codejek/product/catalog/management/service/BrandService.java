package com.codejek.product.catalog.management.service;

import java.util.List;

import com.codejek.product.catalog.management.entity.BrandEntity;

public interface BrandService {

	public BrandEntity create(BrandEntity brandEntity);
	public BrandEntity update(BrandEntity brandEntity);
	public BrandEntity get(long id);
	public List<BrandEntity> getAll();
	public void delete(BrandEntity brandEntity);
	public List<BrandEntity> getAllBySubCat(long subCatid);
	public BrandEntity getByName(String b);
}
