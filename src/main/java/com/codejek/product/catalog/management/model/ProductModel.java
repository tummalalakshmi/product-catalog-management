package com.codejek.product.catalog.management.model;

public class ProductModel {

	private long id;
	private String name;
	private String code;
	private String shortDesc;
	private String longDesc;
	private long creationTime;
	private long lastModifiedTime;
	private String measurementUnit;
	private SubCategoryModel subCategory;
	private BrandModel brand;
	private SellerModel seller;
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
	public String getMeasurementUnit() {
		return measurementUnit;
	}
	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}
	public SubCategoryModel getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategoryModel subCategory) {
		this.subCategory = subCategory;
	}
	public BrandModel getBrand() {
		return brand;
	}
	public void setBrand(BrandModel brand) {
		this.brand = brand;
	}
	public SellerModel getSeller() {
		return seller;
	}
	public void setSeller(SellerModel seller) {
		this.seller = seller;
	}
	public SubCategoryModel getSubCategoryModel() {
		return subCategory;
	}
	public void setSubCategoryModel(SubCategoryModel subCategoryModel) {
		this.subCategory = subCategoryModel;
	}
	public BrandModel getBrandModel() {
		return brand;
	}
	public void setBrandModel(BrandModel brandModel) {
		this.brand = brandModel;
	}
	public SellerModel getSellerModel() {
		return seller;
	}
	public void setSellerModel(SellerModel sellerModel) {
		this.seller = sellerModel;
	}
}
