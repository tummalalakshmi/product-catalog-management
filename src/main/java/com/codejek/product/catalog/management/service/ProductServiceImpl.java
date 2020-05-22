package com.codejek.product.catalog.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codejek.product.catalog.management.entity.ProductEntity;
import com.codejek.product.catalog.management.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ProductEntity create(ProductEntity productEntity) {
		
		return productRepository.save(productEntity);
	}

	@Override
	public ProductEntity update(ProductEntity productEntity) {
		
		return productRepository.save(productEntity);
	}

	@Override
	public ProductEntity get(long id) {
		
		return productRepository.getOne(id);
	}

	@Override
	public List<ProductEntity> getAll() {
		
		return productRepository.findAll();
	}

	@Override
	public void delete(ProductEntity productEntity) {
		
		productRepository.delete(productEntity);
	}
}
