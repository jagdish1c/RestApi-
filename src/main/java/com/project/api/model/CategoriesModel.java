package com.project.api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.api.entity.Categories;
import com.project.api.entity.Products;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CategoriesModel  {
	

	
	public CategoriesModel(Categories categories){
		this.id=categories.getId();
	    this.categoryName=categories.getCategoryName();
	    this.products=categories.getProducts();
	}
	public CategoriesModel(int id,String categoryName){
		this.id=id;
	    this.categoryName=categoryName;
	}

	private Integer id;
	private String categoryName; 
	@JsonIgnoreProperties
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private List<Products> products;
	
}
