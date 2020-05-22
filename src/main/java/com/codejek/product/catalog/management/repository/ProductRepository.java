package com.codejek.product.catalog.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codejek.product.catalog.management.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
