package com.codejek.product.catalog.management.utils;

import java.util.HashSet;
import java.util.Set;

import com.codejek.product.catalog.management.entity.BrandEntity;
import com.codejek.product.catalog.management.entity.CategoryEntity;
import com.codejek.product.catalog.management.entity.ProductEntity;
import com.codejek.product.catalog.management.entity.SubCategoryEntity;
import com.codejek.product.catalog.management.entity.SuperCategoryEntity;
import com.codejek.product.catalog.management.model.BrandModel;
import com.codejek.product.catalog.management.model.CategoryModel;
import com.codejek.product.catalog.management.model.ProductModel;
import com.codejek.product.catalog.management.model.SubCategoryModel;
import com.codejek.product.catalog.management.model.SuperCategoryModel;

public class Mapper {

	public static BrandModel mapBrandEntityToModel(BrandEntity entity) {
		
		BrandModel brandModel = new BrandModel();
		brandModel.setId(entity.getId());
		brandModel.setLongDesc(entity.getLongDesc());
		brandModel.setName(entity.getName());
		brandModel.setShortDesc(entity.getShortDesc());
		brandModel.setCode(entity.getCode());
		Set<String> scSet = new HashSet<String>();
		for(SubCategoryEntity s : entity.getSubCatList()) {
			scSet.add(s.getName());
		}
		brandModel.setSubCatList(scSet);
		return brandModel;
	}
	
	public static BrandEntity mapBrandModeltoEntity(BrandModel brandModel) {
		
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setId(brandModel.getId());
		brandEntity.setLongDesc(brandModel.getLongDesc());
		brandEntity.setName(brandModel.getName());
		brandEntity.setShortDesc(brandModel.getShortDesc());
		brandEntity.setCode(brandModel.getCode());
		return brandEntity;
	}
	
	public static CategoryEntity mapCategoryModeltoEntity(CategoryModel categoryModel) {
		
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(categoryModel.getId());
		categoryEntity.setLongDesc(categoryModel.getLongDesc());
		categoryEntity.setName(categoryModel.getName());
		categoryEntity.setShortDesc(categoryModel.getShortDesc());
		categoryEntity.setCode(categoryModel.getCode());
		categoryEntity.setSuperCatId(mapSuperCategoryModeltoEntity(categoryModel.getSuperCategoryModel()));
		return categoryEntity;
	}
	
	public static CategoryModel mapCategoryEntitytoModel(CategoryEntity categoryEntity) {
		
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setId(categoryEntity.getId());
		categoryModel.setLongDesc(categoryEntity.getLongDesc());
		categoryModel.setName(categoryEntity.getName());
		categoryModel.setShortDesc(categoryEntity.getShortDesc());
		categoryModel.setCode(categoryEntity.getCode());
		categoryModel.setSuperCategoryModel(mapSuperCategoryEntitytoModel(categoryEntity.getSuperCatId()));
		return categoryModel;
	}
	
//	public static SellerEntity mapSellerModeltoEntity(SellerModel sellerModel) {
//		
//		SellerEntity sellerEntity = new SellerEntity();
//		sellerEntity.setId(sellerModel.getId());
//		sellerEntity.setName(sellerModel.getName());
//		return sellerEntity;
//	}
//	
//	public static SellerModel mapSellerEntitytoModel(SellerEntity sellerEntity) {
//		
//		SellerModel sellerModel = new SellerModel();
//		sellerModel.setId(sellerEntity.getId());
//		sellerModel.setName(sellerEntity.getName());
//		return sellerModel;
//	}
	
	public static SubCategoryEntity mapSubCategoryModeltoEntity(SubCategoryModel subCategoryModel) {
		
		SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
		subCategoryEntity.setId(subCategoryModel.getId());
		subCategoryEntity.setLongDesc(subCategoryModel.getLongDesc());
		subCategoryEntity.setName(subCategoryModel.getName());
		subCategoryEntity.setShortDesc(subCategoryModel.getShortDesc());
		subCategoryEntity.setCode(subCategoryModel.getCode());
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(subCategoryModel.getCategoryModel().getId());
		subCategoryEntity.setCategoryId(categoryEntity);
//		Set<BrandEntity> s = new HashSet<BrandEntity>();
//		for(String b: subCategoryModel.getBrandSet()) {
//			BrandEntity e = new BrandEntity();
//			e.setId(b);
//			s.add(e);
//		}
//		subCategoryEntity.setBrandSet(s);
		return subCategoryEntity;
	}
	
	public static SubCategoryModel mapSubCategoryEntitytoModel(SubCategoryEntity subCategoryEntity) {
		
		SubCategoryModel subCategoryModel = new SubCategoryModel();
		subCategoryModel.setId(subCategoryEntity.getId());
		subCategoryModel.setLongDesc(subCategoryEntity.getLongDesc());
		subCategoryModel.setName(subCategoryEntity.getName());
		subCategoryModel.setShortDesc(subCategoryEntity.getShortDesc());
		subCategoryModel.setCode(subCategoryEntity.getCode());
		subCategoryModel.setCategoryModel(mapCategoryEntitytoModel(subCategoryEntity.getCategoryId()));
		Set<BrandModel> s = new HashSet<BrandModel>();
		for(BrandEntity entity:subCategoryEntity.getBrandSet()) {
			BrandModel brandModel = new BrandModel();
			brandModel.setId(entity.getId());
			brandModel.setLongDesc(entity.getLongDesc());
			brandModel.setName(entity.getName());
			brandModel.setShortDesc(entity.getShortDesc());
			brandModel.setCode(entity.getCode());
			s.add(brandModel);
		}
//		subCategoryModel.setBrandSet();
		subCategoryModel.setCreationTime(subCategoryEntity.getCreationTime());
		subCategoryModel.setLastModifiedTime(subCategoryEntity.getLastModifiedTime());
		return subCategoryModel;
	}
	
	public static SuperCategoryEntity mapSuperCategoryModeltoEntity(SuperCategoryModel superCategoryModel) {
		
		SuperCategoryEntity superCategoryEntity = new SuperCategoryEntity();
		superCategoryEntity.setId(superCategoryModel.getId());
		superCategoryEntity.setLongDesc(superCategoryModel.getLongDesc());
		superCategoryEntity.setName(superCategoryModel.getName());
		superCategoryEntity.setShortDesc(superCategoryModel.getShortDesc());
		superCategoryEntity.setCode(superCategoryModel.getCode());
		superCategoryEntity.setCreationTime(superCategoryModel.getCreationTime());
		superCategoryEntity.setLastModifiedTime(superCategoryModel.getLastModifiedTime());
		return superCategoryEntity;
	}
	
	public static SuperCategoryModel mapSuperCategoryEntitytoModel(SuperCategoryEntity superCategoryEntity) {
		
		SuperCategoryModel superCategoryModel = new SuperCategoryModel();
		superCategoryModel.setId(superCategoryEntity.getId());
		superCategoryModel.setLongDesc(superCategoryEntity.getLongDesc());
		superCategoryModel.setName(superCategoryEntity.getName());
		superCategoryModel.setShortDesc(superCategoryEntity.getShortDesc());
		superCategoryModel.setCode(superCategoryEntity.getCode());
		superCategoryModel.setCreationTime(superCategoryEntity.getCreationTime());
		superCategoryModel.setLastModifiedTime(superCategoryEntity.getLastModifiedTime());
		return superCategoryModel;
	}
	
	public static ProductEntity mapProductModeltoEntity(ProductModel productModel) {
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setId(productModel.getId());
		return productEntity;
	}
	
	public static ProductModel mapProductEntitytoModel(ProductEntity productEntity) {
		
		ProductModel productModel = new ProductModel();
		productModel.setId(productEntity.getId());
		return productModel;
	}
}
