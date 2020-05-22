package com.codejek.product.catalog.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productid", updatable = false, nullable = false)
	@JsonIgnore
	private long id;
	@Column(unique = true)
	private String name;
	@Column(unique = true)
	private String code;
	private String shortDesc;
	private String longDesc;
	private long creationTime;
	private long lastModifiedTime;
	private String measurementUnit;
	@OneToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private BrandEntity brandId;
	@OneToOne
	@JoinColumn(name = "sub_category_id", nullable = false)
	private SubCategoryEntity subCatId;
	public String getMeasurementUnit() {
		return measurementUnit;
	}
	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}
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
	public BrandEntity getBrandId() {
		return brandId;
	}
	public void setBrandId(BrandEntity brandId) {
		this.brandId = brandId;
	}
	public SubCategoryEntity getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(SubCategoryEntity subCatId) {
		this.subCatId = subCatId;
	}
}
