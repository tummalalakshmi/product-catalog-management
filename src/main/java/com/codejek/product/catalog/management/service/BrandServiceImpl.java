package com.codejek.product.catalog.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codejek.product.catalog.management.entity.BrandEntity;
import com.codejek.product.catalog.management.repository.BrandRepository;

@Service
@Transactional
public class BrandServiceImpl implements BrandService{

	@Autowired
	BrandRepository brandRepository;
	
	@Override
	public BrandEntity create(BrandEntity brandEntity) {
		
		return brandRepository.save(brandEntity);
	}

	@Override
	public BrandEntity update(BrandEntity brandEntity) {
		
		return brandRepository.save(brandEntity);
	}

	@Override
	public BrandEntity get(long id) {
		
		return brandRepository.getOne(id);
	}

	@Override
	public List<BrandEntity> getAll() {
		
		return brandRepository.findAll();
	}

	@Override
	public void delete(BrandEntity brandEntity) {
		
		brandRepository.delete(brandEntity);
	}

	@Override
	public List<BrandEntity> getAllBySubCat(long subCatId) {
		
		return brandRepository.findAllBySubCat(subCatId);
	}

	@Override
	public BrandEntity getByName(String b) {
		
		return brandRepository.getByName(b);
	}

}
