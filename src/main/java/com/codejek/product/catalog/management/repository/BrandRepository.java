package com.codejek.product.catalog.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codejek.product.catalog.management.entity.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity, Long>{

	@Query("Select b from BrandEntity b LEFT JOIN b.subCatList s where s.id = ?1 ")
	List<BrandEntity> findAllBySubCat(long subCatId);

	@Query("select b from BrandEntity b where b.name = ?1")
	BrandEntity getByName(String b);

}
