package com.codejek.product.catalog.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="category", uniqueConstraints= @UniqueConstraint(columnNames={"name"}))
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id", updatable = false, nullable = false)
	@JsonIgnore
	private long id;
	private String name;
	@Column(unique = true)
	private String code;
	@ManyToOne
	@JoinColumn(name = "super_category_id", nullable = false)
	private SuperCategoryEntity superCatId;
	private String shortDesc;
	private String longDesc;
	private long creationTime;
	private long lastModifiedTime;
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
	public SuperCategoryEntity getSuperCatId() {
		return superCatId;
	}
	public void setSuperCatId(SuperCategoryEntity superCatId) {
		this.superCatId = superCatId;
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
}
