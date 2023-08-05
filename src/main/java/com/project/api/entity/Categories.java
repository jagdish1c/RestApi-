package com.project.api.entity;

import java.util.List;

import com.project.api.model.CategoriesModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Categories {
	public Categories(CategoriesModel categoriesModel) {
		this.id=categoriesModel.getId();
		this.categoryName=categoriesModel.getCategoryName();
		this.products=categoriesModel.getProducts();
	}
	
	@Id
	private Integer id;
	@Column(name = "category_name")
	private String categoryName;
	@OneToMany(mappedBy = "categories" , cascade = CascadeType.ALL)
	private List<Products> products;
	 
}
