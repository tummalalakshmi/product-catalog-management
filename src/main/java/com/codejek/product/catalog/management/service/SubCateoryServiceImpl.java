package com.codejek.product.catalog.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codejek.product.catalog.management.entity.SubCategoryEntity;
import com.codejek.product.catalog.management.repository.SubCategoryRepository;

@Service
@Transactional
public 
class SubCateoryServiceImpl implements SubCateoryService{

	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Override
	public SubCategoryEntity create(SubCategoryEntity subCategoryEntity) {

		return subCategoryRepository.save(subCategoryEntity);
	}

	@Override
	public SubCategoryEntity update(SubCategoryEntity subCategoryEntity) {
		
		return subCategoryRepository.save(subCategoryEntity);
	}

	@Override
	public SubCategoryEntity get(long id) {
		
		return subCategoryRepository.getOne(id);
	}

	@Override
	public List<SubCategoryEntity> getAll() {
		
		return subCategoryRepository.findAll();
	}

	@Override
	public void delete(SubCategoryEntity subCategoryEntity) {
		
		subCategoryRepository.delete(subCategoryEntity);
	}

	@Override
	public SubCategoryEntity getByName(String name) {
		
		return subCategoryRepository.findByName(name);
	}

	@Override
	public List<SubCategoryEntity> findAllSubCatByCat(long catId) {
		
		return subCategoryRepository.findSubCatByCat(catId);
	}
}
