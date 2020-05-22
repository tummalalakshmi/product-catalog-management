package com.codejek.product.catalog.management.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

//import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sub_category", uniqueConstraints= @UniqueConstraint(columnNames={"name"}))
public class SubCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sub_category_id", updatable = false, nullable = false)
	@JsonIgnore
	private long id;
	private String name;
	@Column(unique = true)
	private String code;
	private String shortDesc;
	private String longDesc;
	private long creationTime;
	private long lastModifiedTime;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryEntity categoryId;
	@ManyToMany(mappedBy = "subCatList")
	private Set<BrandEntity> brandSet;
	public Set<BrandEntity> getBrandSet() {
		return brandSet;
	}
	public void setBrandSet(Set<BrandEntity> brandSet) {
		this.brandSet = brandSet;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public CategoryEntity getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(CategoryEntity categoryId) {
		this.categoryId = categoryId;
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
}
