package com.codejek.product.catalog.management.model;

import java.util.Set;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Brand")
@Validated
@Data
public class BrandModel {

	private long id;
	private String name;
	private String code;
	private String shortDesc;
	private String longDesc;
	private long creationTime;
	private long lastModifiedTime;
	private Set<String> subCatList;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
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
	public Set<String> getSubCatList() {
		return subCatList;
	}
	public void setSubCatList(Set<String> subCatList) {
		this.subCatList = subCatList;
	}
}
