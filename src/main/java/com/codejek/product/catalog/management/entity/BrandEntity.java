package com.codejek.product.catalog.management.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="brand", uniqueConstraints= @UniqueConstraint(columnNames={"name"}))
public class BrandEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "brand_id", updatable = false, nullable = false)
	@JsonIgnore
	private long id;
	private String name;
	@Column(unique = true)
	private String code;
	private String shortDesc;
	private String longDesc;
	private long creationTime;
	private long lastModifiedTime;
	@ManyToMany
	@JoinTable(name = "product_brand", joinColumns = { @JoinColumn(name = "brand_id") }, inverseJoinColumns = { @JoinColumn(name = "sub_category_id") })
	private Set<SubCategoryEntity> subCatList;
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
	public Set<SubCategoryEntity> getSubCatList() {
		return subCatList;
	}
	public void setSubCatList(Set<SubCategoryEntity> subCatList) {
		this.subCatList = subCatList;
	}
}
