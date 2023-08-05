package com.project.api.service;

import java.util.List;

import com.project.api.entity.Categories;
import com.project.api.model.CategoriesModel;


public interface CategoriesService {
	public CategoriesModel categoriesCreate(CategoriesModel categoriesModel);
	public List<CategoriesModel> getCategories();
	public List<CategoriesModel> getCategories(int page);
	public CategoriesModel getByCategoriesId(Integer id);
	public String updateCategories(CategoriesModel categoriesModel,Integer id);
	public String deleteByCategoriesId(int id);
}
