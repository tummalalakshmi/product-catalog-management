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
import com.codejek.product.catalog.management.model.BrandModel;
import com.codejek.product.catalog.management.service.BrandService;
import com.codejek.product.catalog.management.service.SubCateoryService;
import com.codejek.product.catalog.management.utils.Mapper;

@Component
public class BrandProcessor {

	@Autowired
	BrandService brandService;
	
	@Autowired
	SubCateoryService subCateoryService;
	public long addBrand(BrandModel brandModel) {
		
		BrandEntity brandEntity = Mapper.mapBrandModeltoEntity(brandModel);
		Set<SubCategoryEntity> sc = new HashSet<SubCategoryEntity>();
		for(String name : brandModel.getSubCatList()) {
			sc.add(subCateoryService.getByName(name));
		}
		brandEntity.setSubCatList(sc);
		Date date = new Date();
		brandEntity.setCreationTime(date.getTime());
		brandEntity.setLastModifiedTime(date.getTime());
		
		brandEntity = brandService.create(brandEntity);
		 return brandEntity.getId();
	}
	
	public long modifyBrand(BrandModel brandModel) {
		
		BrandEntity brandEntity = Mapper.mapBrandModeltoEntity(brandModel);
		Set<SubCategoryEntity> sc = new HashSet<SubCategoryEntity>();
		for(String name : brandModel.getSubCatList()) {
			sc.add(subCateoryService.getByName(name));
		}
		brandEntity.setSubCatList(sc);
		Date date = new Date();
		brandEntity.setLastModifiedTime(date.getTime());
		
		brandEntity = brandService.update(brandEntity);
		return brandEntity.getId();
	}
	
	public BrandModel getBrandModel(long id) {
		
		BrandEntity brandEntity = brandService.get(id);
		
		return Mapper.mapBrandEntityToModel(brandEntity);
	}
	
	public List<BrandModel> findAllBrands(){
		
		List <BrandEntity> be = brandService.getAll();
		
		List<BrandModel> bm = new ArrayList<BrandModel>();
		for(BrandEntity b : be) {
			bm.add(Mapper.mapBrandEntityToModel(b));
		}
		return bm;
	}
	
	public List<BrandModel> findAllBrandsBySubCat(long subCatid){
		
		List <BrandEntity> be = brandService.getAllBySubCat(subCatid);
		
		List<BrandModel> bm = new ArrayList<BrandModel>();
		for(BrandEntity b : be) {
			bm.add(Mapper.mapBrandEntityToModel(b));
		}
		return bm;
	}
	
	public void removeBrand(long id) {
		
		brandService.delete(Mapper.mapBrandModeltoEntity(getBrandModel(id)));
	}
}
