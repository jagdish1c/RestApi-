package com.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.model.CategoriesModel;
import com.project.api.model.ProductsModel;
import com.project.api.service.CategoriesService;
import com.project.api.service.ProductsService;

@RestController
public class ProductController {
	@Autowired
    private ProductsService productsService;
	
	@PostMapping("/api/products")
	public ProductsModel createProducts(@RequestBody ProductsModel productsModel) {
		return productsService.productCreate(productsModel); 
	}
	
	@GetMapping("/api/products")
	public List<ProductsModel> getproducts(@RequestParam(defaultValue = "0") int page) {
		return productsService.getProducts(page);
	}
	
	@GetMapping("/api/products/{catId}")
	public ProductsModel getProductsById(@PathVariable Integer catId) {
		return productsService.getByProductId(catId);
	}
	
	@DeleteMapping("/api/products/{catId}")
	public String deleteProductsById(@PathVariable Integer catId) {
		return productsService.deleteByProductId(catId);
	}
	
	@PutMapping("/api/products/{catId}")
	public String upProductModels(@RequestBody ProductsModel productsModel ,@PathVariable Integer catId) {
		return productsService.updateProduct(productsModel,catId);
	}

}
