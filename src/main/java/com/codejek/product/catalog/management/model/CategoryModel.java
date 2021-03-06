
package com.codejek.product.catalog.management.model;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Category")
@Validated
public class CategoryModel {

	@JsonProperty("id")
	private long id;
	
	@JsonProperty("name")
	private String name = null;

	@JsonProperty("short_desc")
	private String shortDesc = null;
	  
	@JsonProperty("long_desc")
	private String longDesc = null;
	  
	@JsonProperty("code")
	private String code = null;
	
	private SuperCategoryModel superCategory;
	
	private long creationTime;
	private long lastModifiedTime;
	  
	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}

	public long getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public SuperCategoryModel getSuperCategoryModel() {
		return superCategory;
	}

	public void setSuperCategoryModel(SuperCategoryModel superCategoryModel) {
		this.superCategory = superCategoryModel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
}
