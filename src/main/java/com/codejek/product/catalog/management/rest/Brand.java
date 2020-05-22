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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codejek.product.catalog.management.model.BrandModel;
import com.codejek.product.catalog.management.processor.BrandProcessor;

@Controller
@RequestMapping(path="/brand")
public class Brand {

	private static final Logger log = LoggerFactory
			.getLogger(Brand.class);
	@Autowired
	BrandProcessor brandProcessor;
	@PostMapping(path="/")
	public @ResponseBody String addBrand (@RequestBody BrandModel brandModel) {

		log.info("Start of addBrand");
		if(brandProcessor.addBrand(brandModel)>0){
			log.info("End of addBrand");
			return "Saved";
		}
		return "Error";
	}
	
	@PutMapping(path="/")
	public @ResponseBody String modifyBrand (@RequestBody BrandModel brandModel) {

		if(brandProcessor.modifyBrand(brandModel)>0){
			return "Modified";
		}
		return "Error";
	}
	
	@GetMapping(path="")
	public @ResponseBody List<BrandModel> findAllBrandsBySubCar(@RequestParam(value = "subCatId") Long subCatId){
		log.info("Start of findAllBrandsBySubCar");
		return brandProcessor.findAllBrandsBySubCat(subCatId);
	}
	
	@GetMapping(path="/")
	public @ResponseBody List<BrandModel> findAllBrands(){
		log.info("Start of findAllBrands");
		return brandProcessor.findAllBrands();
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody void deleteBrand(@PathVariable("id") Long id) {
		
		brandProcessor.removeBrand(id);
	}
}
