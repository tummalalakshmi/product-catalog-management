package com.codejek.product.catalog.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codejek.product.catalog.management.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	@Query("Select s from CategoryEntity s where s.superCatId.id = ?1")
	List<CategoryEntity> findAllCatBySupCat(long supCatId);
}
