package com.codejek.product.catalog.management.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codejek.product.catalog.management.model.ProductModel;
import com.codejek.product.catalog.management.processor.ProductProcessor;

@Controller
@RequestMapping(path="/product")
public class Product {

	private static final Logger log = LoggerFactory.getLogger(Product.class);
	@Autowired
	ProductProcessor productProcessor;
	@PostMapping(path="/")
	public @ResponseBody String addProduct (@RequestBody ProductModel productModel) {

		log.info("Adding Product");
		if(productProcessor.addProduct(productModel)>0){
			return "Saved";
		}
		return "Error";
	}
	
	@PutMapping(path="/")
	public @ResponseBody String modifyProduct (@RequestBody ProductModel productModel) {

		if(productProcessor.modifyProduct(productModel)>0){
			return "Modified";
		}
		return "Error";
	}
	
	@GetMapping(path="/")
	public @ResponseBody List<ProductModel> findAllProducts(){
		
		return productProcessor.findAllProducts();
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody void deleteProduct(@PathVariable("id") Long id) {
		
		productProcessor.removeProduct(id);
	}
}
