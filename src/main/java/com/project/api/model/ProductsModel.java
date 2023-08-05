package com.project.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.api.entity.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductsModel {

	public ProductsModel(Products products) {
		 this.pid=products.getPId();
		 this.productName=products.getProductName();
		 this.brandName=products.getBrandName();
		 categories = new CategoriesModel();
		 categories.setCategoryName(products.getCategories().getCategoryName());
		 categories.setId(products.getCategories().getId());
		 
	}
	public ProductsModel(int id,String productName){
		this.pid=id;
	    this.productName=productName;
	}
	public ProductsModel(int id,String productName,String brandName){
		this.pid=id;
	    this.productName=productName;
	    this.brandName=brandName;
	}
	private int pid;
	private String productName;
	private String brandName;
	@JsonIgnoreProperties
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private CategoriesModel categories;
	 
}
