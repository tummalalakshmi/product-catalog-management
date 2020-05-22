package com.codejek.product.catalog.management.rest;

import java.util.List;

import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codejek.product.catalog.management.model.CategoryModel;
import com.codejek.product.catalog.management.processor.CategoryProcessor;

@Controller
@RequestMapping(path="/category")
public class Category {

	private static final Logger log = LoggerFactory
			.getLogger(Category.class);
	@Autowired
	CategoryProcessor categoryProcessor;
	@PostMapping(path="/")
	public @ResponseBody String addCategory (@RequestBody CategoryModel categoryModel) {

		if(categoryProcessor.addCategory(categoryModel)>0){
			return "Saved";
		}
		return "Error";
	}
	
	@PutMapping(path="/")
	public @ResponseBody String modifyCategory (@RequestBody CategoryModel categoryModel) {

		if(categoryProcessor.modifyCategory(categoryModel)>0){
			return "Modified";
		}
		return "Error";
	}
	
	@GetMapping(path="/")
	public @ResponseBody List<CategoryModel> findAllCategorys(){
		
		return categoryProcessor.findAllCategorys();
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody void deleteCategory(@PathVariable("id") Long id) {
		
		categoryProcessor.removeCategory(id);
	}
	
	@GetMapping(path="")
	public @ResponseBody List<CategoryModel> findAllCategorysBySupCat(@RequestParam(value="supCatId") Long supCatId){
		
		log.info("start of findAllCategorysBySupCat");
		return categoryProcessor.findAllCategorysBySupCat(supCatId);
	}
}
