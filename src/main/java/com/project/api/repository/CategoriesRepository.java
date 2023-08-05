package com.project.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

	
}
