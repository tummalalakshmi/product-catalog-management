package com.codejek.product.catalog.management.rest;

import java.util.List;

import javax.websocket.server.PathParam;

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

import com.codejek.product.catalog.management.model.SubCategoryModel;
import com.codejek.product.catalog.management.processor.SubCategoryProcessor;

@Controller
@RequestMapping(path="/subCategory")
public class SubCategory {

	@Autowired
	SubCategoryProcessor subCategoryProcessor;
	@PostMapping(path="/")
	public @ResponseBody String addSubCategory (@RequestBody SubCategoryModel subCategoryModel) {

		if(subCategoryProcessor.addSubCategory(subCategoryModel)>0){
			return "Saved";
		}
		return "Error";
	}
	
	@PutMapping(path="/")
	public @ResponseBody String modifySubCategory (@RequestBody SubCategoryModel subCategoryModel) {

		if(subCategoryProcessor.modifySubCategory(subCategoryModel)>0){
			return "Modified";
		}
		return "Error";
	}
	
	@GetMapping(path="/")
	public @ResponseBody List<SubCategoryModel> findAllSubCategorys(){
		
		return subCategoryProcessor.findAllSubCategorys();
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody void deleteSubCategory(@PathVariable("id") Long id) {
		
		subCategoryProcessor.removeSubCategory(id);
	}
	
	@GetMapping(path="")
	public @ResponseBody List<SubCategoryModel> findAllSubCategorysByCat(@RequestParam(value = "categoryId")
			 Long categoryId){
		
		return subCategoryProcessor.findAllSubCategorysByCat(categoryId);
	}
}
