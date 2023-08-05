package com.project.api.service;

import java.util.List;

import com.project.api.model.ProductsModel;

public interface ProductsService {
	public ProductsModel productCreate(ProductsModel productModel);
	public List<ProductsModel> getProducts();
	public List<ProductsModel> getProducts(int page);
	public ProductsModel getByProductId(Integer id);
	public String updateProduct(ProductsModel productModel,Integer id);
	public String deleteByProductId(int id);
}
