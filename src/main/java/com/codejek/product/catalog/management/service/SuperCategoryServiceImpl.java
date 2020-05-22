package com.codejek.product.catalog.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codejek.product.catalog.management.entity.SuperCategoryEntity;
import com.codejek.product.catalog.management.repository.SuperCategoryRepository;

@Service
@Transactional
public class SuperCategoryServiceImpl implements SuperCategoryService{

	@Autowired
	SuperCategoryRepository superCategoryRepository;
	
	@Override
	public SuperCategoryEntity create(SuperCategoryEntity superCategoryEntity) {
		
		return superCategoryRepository.save(superCategoryEntity);
	}

	@Override
	public SuperCategoryEntity update(SuperCategoryEntity superCategoryEntity) {
		
		return superCategoryRepository.save(superCategoryEntity);
	}
	
	@Override
	public SuperCategoryEntity get(long id) {
		
		return superCategoryRepository.getOne(id);
	}

	@Override
	public List<SuperCategoryEntity> getAll() {
		
		return superCategoryRepository.findAll();
	}

	@Override
	public void delete(SuperCategoryEntity superCategoryEntity) {
		
		superCategoryRepository.delete(superCategoryEntity);
	}
}
