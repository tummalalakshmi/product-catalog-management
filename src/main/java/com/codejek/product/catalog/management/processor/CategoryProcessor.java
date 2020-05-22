package com.codejek.product.catalog.management.processor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codejek.product.catalog.management.entity.CategoryEntity;
import com.codejek.product.catalog.management.model.CategoryModel;
import com.codejek.product.catalog.management.service.CategoryService;
import com.codejek.product.catalog.management.utils.Mapper;

@Component
public class CategoryProcessor {

	@Autowired
	CategoryService cateoryService;
	
	public long addCategory(CategoryModel categoryModel) {
		
		CategoryEntity categoryEntity = Mapper.mapCategoryModeltoEntity(categoryModel);
		Date date = new Date();
		categoryEntity.setCreationTime(date.getTime());
		categoryEntity.setLastModifiedTime(date.getTime());
		
		categoryEntity = cateoryService.create(categoryEntity);
		 return categoryEntity.getId();
	}
	
	public long modifyCategory(CategoryModel categoryModel) {
		
		CategoryEntity categoryEntity = Mapper.mapCategoryModeltoEntity(categoryModel);
		Date date = new Date();
		categoryEntity.setLastModifiedTime(date.getTime());
		
		categoryEntity = cateoryService.update(categoryEntity);
		 return categoryEntity.getId();
	}
	
	public CategoryModel getCategoryModel(long id) {
		
		CategoryEntity categoryEntity = cateoryService.get(id);
		
		return Mapper.mapCategoryEntitytoModel(categoryEntity);
	}
	
	public List<CategoryModel> findAllCategorys(){
		
		List <CategoryEntity> be = cateoryService.getAll();
		
		List<CategoryModel> bm = new ArrayList<CategoryModel>();
		for(CategoryEntity b : be) {
			bm.add(Mapper.mapCategoryEntitytoModel(b));
		}
		return bm;
	}
	
	public void removeCategory(long id) {
		
		cateoryService.delete(Mapper.mapCategoryModeltoEntity(getCategoryModel(id)));
	}

	public List<CategoryModel> findAllCategorysBySupCat(long supCatId) {

		List <CategoryEntity> be = cateoryService.getAllCatBySupCat(supCatId);
		
		List<CategoryModel> bm = new ArrayList<CategoryModel>();
		for(CategoryEntity b : be) {
			bm.add(Mapper.mapCategoryEntitytoModel(b));
		}
		return bm;
	}
}
