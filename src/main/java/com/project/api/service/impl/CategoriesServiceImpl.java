package com.project.api.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project.api.entity.Categories;
import com.project.api.model.CategoriesModel;
import com.project.api.repository.CategoriesRepository;
import com.project.api.service.CategoriesService;
@Service
public class CategoriesServiceImpl implements CategoriesService{
	@Autowired
	private CategoriesRepository categoriesRepository;
	 
	
	@Override
	public CategoriesModel categoriesCreate(CategoriesModel categoriesModel) {
		Categories categories= categoriesRepository.save( new Categories(categoriesModel));
		CategoriesModel category= new CategoriesModel(categories);
		return category;
		}

	@Override
	public List<CategoriesModel> getCategories() {
		List<Categories>  categoriesList = categoriesRepository.findAll();
		List<CategoriesModel> categoriesModeList= new ArrayList<CategoriesModel>();
		for (Categories Categories : categoriesList) {
			CategoriesModel categoriesModel = new CategoriesModel();
			categoriesModel.setId(Categories.getId());
			categoriesModel.setCategoryName(Categories.getCategoryName());
			categoriesModeList.add(categoriesModel);
		}
		
		return categoriesModeList;
		
	}

	@Override
	public CategoriesModel getByCategoriesId(Integer id) {
		Categories categories = categoriesRepository.findById(id).orElse(null);
		return new CategoriesModel(categories.getId(),categories.getCategoryName());
	}

	@Override
	public String updateCategories(CategoriesModel newCategoriesModel,Integer id) {
		List<CategoriesModel> categoriesModelList = getCategories();
		CategoriesModel categoriesModel =  categoriesModelList.stream().filter(data->data.getId()==id).findFirst().get();
		 if(categoriesModel!=null) {
			 categoriesRepository.save(new Categories(newCategoriesModel));
			 return "Success";
		 }else {
			 return "Un- Success : Can Not Update Data with Id="+ id;
		 }
	 
	}

	@Override
	public String deleteByCategoriesId(int id) {
		   categoriesRepository.deleteById(id);
		   return "success";
	}
	
	@Override
	public List<CategoriesModel> getCategories(int page) {
		PageRequest pageable =  PageRequest.of(page,10);
		List<Categories>  categoriesList = categoriesRepository.findAll(pageable).getContent() ;
		List<CategoriesModel> categoriesModeList= new ArrayList<CategoriesModel>();
		for (Categories Categories : categoriesList) {
			CategoriesModel categoriesModel = new CategoriesModel();
			categoriesModel.setId(Categories.getId());
			categoriesModel.setCategoryName(Categories.getCategoryName());
			categoriesModeList.add(categoriesModel);
		}
		
		return categoriesModeList;	
	}

	
}
