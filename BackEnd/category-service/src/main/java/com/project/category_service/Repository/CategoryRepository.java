package com.project.category_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.category_service.Model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
	

}
