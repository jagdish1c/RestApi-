package com.project.api.entity;
import com.project.api.model.ProductsModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Products {
	public Products(ProductsModel productModel) {
	 this.pId=productModel.getPid();
	 this.brandName=productModel.getBrandName();
	 this.productName= productModel.getProductName();
	 this.categories=new Categories();
	 this.categories.setId(productModel.getCategories().getId());
	 
	}
	@Id
	private int pId;
	@Column (name="p_name")
	private String productName;
	@Column (name="brand_name")
	private String brandName;
	@ManyToOne()
	@JoinColumn(name = "id" , insertable = true , updatable = true)
	private Categories categories;
	 
}
