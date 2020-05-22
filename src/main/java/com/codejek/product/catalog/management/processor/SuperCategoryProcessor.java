package com.codejek.product.catalog.management.processor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codejek.product.catalog.management.entity.SuperCategoryEntity;
import com.codejek.product.catalog.management.model.SuperCategoryModel;
import com.codejek.product.catalog.management.service.SuperCategoryService;
import com.codejek.product.catalog.management.utils.Mapper;

@Component
public class SuperCategoryProcessor {

	private static final Logger log = LoggerFactory
			.getLogger(SuperCategoryProcessor.class);
	@Autowired
	SuperCategoryService superCategoryService;
	
	public long addSuperCategory(SuperCategoryModel superCategoryModel) {
		
		SuperCategoryEntity superCategoryEntity = Mapper.mapSuperCategoryModeltoEntity(superCategoryModel);
		Date date = new Date();
		superCategoryEntity.setCreationTime(date.getTime());
		superCategoryEntity.setLastModifiedTime(date.getTime());
		
		superCategoryEntity = superCategoryService.create(superCategoryEntity);
		 return superCategoryEntity.getId();
	}
	
	public long modifySuperCategory(SuperCategoryModel superCategoryModel) {
		
		SuperCategoryEntity superCategoryEntity = Mapper.mapSuperCategoryModeltoEntity(superCategoryModel);
		Date date = new Date();
		superCategoryEntity.setLastModifiedTime(date.getTime());
		
		superCategoryEntity = superCategoryService.update(superCategoryEntity);
		 return superCategoryEntity.getId();
	}
	
	public SuperCategoryModel getSuperCategoryModel(long id) {
		
		SuperCategoryEntity superCategoryEntity = superCategoryService.get(id);
		
		return Mapper.mapSuperCategoryEntitytoModel(superCategoryEntity);
	}
	
	public List<SuperCategoryModel> findAllSuperCategorys(){
		
		List <SuperCategoryEntity> be = superCategoryService.getAll();
		
		List<SuperCategoryModel> bm = new ArrayList<SuperCategoryModel>();
		for(SuperCategoryEntity b : be) {
			bm.add(Mapper.mapSuperCategoryEntitytoModel(b));
		}
		log.info("findAllSuperCategorys" + bm.size());
		return bm;
	}
	
	public void removeSuperCategory(long id) {
		
		superCategoryService.delete(Mapper.mapSuperCategoryModeltoEntity(getSuperCategoryModel(id)));
	}
}
