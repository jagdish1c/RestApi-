package com.project.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project.api.entity.Categories;
import com.project.api.entity.Products;
import com.project.api.model.CategoriesModel;
import com.project.api.model.ProductsModel;
import com.project.api.repository.ProductsRepository;
import com.project.api.service.ProductsService;
@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsRepository productsRepository;
	
	
	@Override
	public ProductsModel productCreate(ProductsModel productModel) {
		Products products=productsRepository.save(new Products(productModel));
	 return new ProductsModel(products);
	}

	@Override
	public List<ProductsModel> getProducts() {
		List<Products>  productList = productsRepository.findAll();
		List<ProductsModel> productModelList= new ArrayList<ProductsModel>();
		for (Products product : productList) {
			ProductsModel productModel1= new ProductsModel();
			productModel1.setPid(product.getPId());
			productModel1.setProductName(product.getProductName());
			productModelList.add(productModel1);
		}
		return productModelList;
	}

	@Override
	public ProductsModel getByProductId(Integer id) {
		Products products = productsRepository.findById(id).orElse(null);
		return new ProductsModel(products.getPId(),products.getProductName(),products.getBrandName());
	}

	@Override
	public String updateProduct(ProductsModel newProductModel,Integer id) {
		List<ProductsModel> productsModelList = getProducts();
		ProductsModel productModel =  productsModelList.stream().filter(data->data.getPid()==id).findFirst().get();
		 if(productModel!=null) {
			 productsRepository.save(new Products(newProductModel));
			 return "Success";
		 }else {
			 return "Un- Success : Can Not Update Data with Id="+ id;
		 }
	 
	}

	
	@Override
	public String deleteByProductId(int id) {
		productsRepository.deleteById(id);
		return "Success";
	}

	@Override
	public List<ProductsModel> getProducts(int page) {
		PageRequest pageable =  PageRequest.of(page,10);
		List<Products>  productsList = productsRepository.findAll(pageable).getContent() ;
		List<ProductsModel> productModeList= new ArrayList<ProductsModel>();
		for (Products products : productsList) {
			ProductsModel prductModel = new ProductsModel();
			prductModel.setPid(products.getPId());
			prductModel.setProductName(products.getProductName());
			prductModel.setBrandName(products.getBrandName());
			productModeList.add(prductModel);
		}
		return productModeList;
	}

}
