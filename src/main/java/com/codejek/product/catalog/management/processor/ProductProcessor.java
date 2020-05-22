 package com.codejek.product.catalog.management.processor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codejek.product.catalog.management.entity.ProductEntity;
import com.codejek.product.catalog.management.model.ProductModel;
import com.codejek.product.catalog.management.service.ProductService;
import com.codejek.product.catalog.management.utils.Mapper;

@Component
public class ProductProcessor {

	@Autowired
	ProductService productService;
	
	public long addProduct(ProductModel productModel) {
		
		ProductEntity productEntity = Mapper.mapProductModeltoEntity(productModel);
		Date date = new Date();
		productEntity.setCreationTime(date.getTime());
		productEntity.setLastModifiedTime(date.getTime());
		
		productEntity = productService.create(productEntity);
		 return productEntity.getId();
	}
	
	public long modifyProduct(ProductModel productModel) {
		
		ProductEntity productEntity = Mapper.mapProductModeltoEntity(productModel);
		Date date = new Date();
		productEntity.setLastModifiedTime(date.getTime());
		
		productEntity = productService.update(productEntity);
		 return productEntity.getId();
	}
	
	public ProductModel getProductModel(long id) {
		
		ProductEntity productEntity = productService.get(id);
		
		return Mapper.mapProductEntitytoModel(productEntity);
	}
	
	public List<ProductModel> findAllProducts(){
		
		List <ProductEntity> be = productService.getAll();
		
		List<ProductModel> bm = new ArrayList<ProductModel>();
		for(ProductEntity b : be) {
			bm.add(Mapper.mapProductEntitytoModel(b));
		}
		return bm;
	}
	
	public void removeProduct(long id) {
		
		productService.delete(Mapper.mapProductModeltoEntity(getProductModel(id)));
	}
}
