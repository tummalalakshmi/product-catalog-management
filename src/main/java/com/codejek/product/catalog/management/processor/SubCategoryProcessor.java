package com.codejek.product.catalog.management.processor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codejek.product.catalog.management.entity.BrandEntity;
import com.codejek.product.catalog.management.entity.SubCategoryEntity;
import com.codejek.product.catalog.management.model.SubCategoryModel;
import com.codejek.product.catalog.management.service.BrandService;
import com.codejek.product.catalog.management.service.SubCateoryService;
import com.codejek.product.catalog.management.utils.Mapper;

@Component
public class SubCategoryProcessor {

	@Autowired
	SubCateoryService subCateoryService;
	
	@Autowired
	BrandService brandService;
	public long addSubCategory(SubCategoryModel subCategoryModel) {

		SubCategoryEntity subCategoryEntity = Mapper.mapSubCategoryModeltoEntity(subCategoryModel);
		Set<BrandEntity> s = new HashSet<BrandEntity>();
		for(String b: subCategoryModel.getBrandSet()) {
			BrandEntity e = new BrandEntity();
			
			s.add(brandService.getByName(b));
		}
		subCategoryEntity.setBrandSet(s);
		Date date = new Date();
		subCategoryEntity.setCreationTime(date.getTime());
		subCategoryEntity.setLastModifiedTime(date.getTime());
		
		subCategoryEntity = subCateoryService.create(subCategoryEntity);
		 return subCategoryEntity.getId();

	}

	public long modifySubCategory(SubCategoryModel subCategoryModel) {
		
		SubCategoryEntity subCategoryEntity = Mapper.mapSubCategoryModeltoEntity(subCategoryModel);
		Date date = new Date();
		subCategoryEntity.setCreationTime(date.getTime());
		
		subCategoryEntity = subCateoryService.update(subCategoryEntity);
		 return subCategoryEntity.getId();
	}
	
	public SubCategoryModel getSubCategoryModel(long id) {
		
		SubCategoryEntity subCategoryEntity = subCateoryService.get(id);
		
		return Mapper.mapSubCategoryEntitytoModel(subCategoryEntity);
	}
	
	public List<SubCategoryModel> findAllSubCategorys(){
		
		List <SubCategoryEntity> be = subCateoryService.getAll();
		
		List<SubCategoryModel> bm = new ArrayList<SubCategoryModel>();
		for(SubCategoryEntity b : be) {
			bm.add(Mapper.mapSubCategoryEntitytoModel(b));
		}
		return bm;
	}
	
	public List<SubCategoryModel> findAllSubCategorysByCat(long catId){
		
		List <SubCategoryEntity> be = subCateoryService.findAllSubCatByCat(catId);
		
		List<SubCategoryModel> bm = new ArrayList<SubCategoryModel>();
		for(SubCategoryEntity b : be) {
			bm.add(Mapper.mapSubCategoryEntitytoModel(b));
		}
		return bm;
	}
	
	public void removeSubCategory(long id) {
		
		subCateoryService.delete(Mapper.mapSubCategoryModeltoEntity(getSubCategoryModel(id)));
	}
}
