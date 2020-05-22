package com.codejek.product.catalog.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codejek.product.catalog.management.entity.SubCategoryEntity;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Long>{

	@Query("select s from SubCategoryEntity s where s.name = ?1")
	SubCategoryEntity findByName(String name);

	@Query("Select s from SubCategoryEntity s where s.categoryId.id = ?1")
	List<SubCategoryEntity> findSubCatByCat(long catId);
}
