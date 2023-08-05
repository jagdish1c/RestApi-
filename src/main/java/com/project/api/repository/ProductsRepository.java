package com.project.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.api.entity.Products;


public interface ProductsRepository extends JpaRepository<Products, Integer> {


}