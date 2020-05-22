package com.codejek.product.catalog.management.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codejek.product.catalog.management.model.SuperCategoryModel;
import com.codejek.product.catalog.management.processor.SuperCategoryProcessor;

@Controller
@RequestMapping(path="/superCategory")
@CrossOrigin(origins = "*")
public class SuperCategory {

	private static final Logger log = LoggerFactory
			.getLogger(SubCategory.class);
	@Autowired
	SuperCategoryProcessor superCategoryProcessor;
	@PostMapping(path="/")
	public @ResponseBody String addSuperCategory (@RequestBody SuperCategoryModel superCategoryModel) {

		if(superCategoryProcessor.addSuperCategory(superCategoryModel)>0){
			return "Saved";
		}
		return "Error";
	}
	
	@PutMapping(path="/")
	public @ResponseBody String modifySuperCategory (@RequestBody SuperCategoryModel superCategoryModel) {

		if(superCategoryProcessor.modifySuperCategory(superCategoryModel)>0){
			return "Modified";
		}
		return "Error";
	}
	
	@GetMapping(path="/")
	public @ResponseBody List<SuperCategoryModel> findAllSuperCategorys(){
		log.info("Start of findAllSuperCategorys");
		return superCategoryProcessor.findAllSuperCategorys();
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody void deleteSuperCategory(@PathVariable("id") Long id) {
		
		superCategoryProcessor.removeSuperCategory(id);
	}
}
