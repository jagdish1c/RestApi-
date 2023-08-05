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
import com.project.api.service.CategoriesService;

@RestController
public class CategoriesController {
	@Autowired
	private CategoriesService categoriesService;
	
	
	@PostMapping("/api/categories")
	public CategoriesModel createCategories(@RequestBody CategoriesModel categoriesModel) {
		return categoriesService.categoriesCreate(categoriesModel);    
	}
	
	

	
	@GetMapping("/api/categories")
	public List<CategoriesModel> getCategories(@RequestParam(defaultValue = "0") int page) {
		return categoriesService.getCategories(page);
	}
	
	@GetMapping("/api/categories/{catId}")
	public CategoriesModel getCategoriesById(@PathVariable Integer catId) {
		return categoriesService.getByCategoriesId(catId);
	}
	
	@DeleteMapping("/api/categories/{catId}")
	public String deleteCategoriesById(@PathVariable Integer catId) {
		return categoriesService.deleteByCategoriesId(catId);
	}
	
	@PutMapping("/api/categories/{catId}")
	public String upCategoriesModels(@RequestBody CategoriesModel categoriesModel,@PathVariable Integer catId) {
		return categoriesService.updateCategories(categoriesModel,catId);
	}
}
