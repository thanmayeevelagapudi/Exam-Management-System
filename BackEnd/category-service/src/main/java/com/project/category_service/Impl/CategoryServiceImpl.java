package com.project.category_service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.category_service.Model.Category;
import com.project.category_service.Repository.CategoryRepository;
import com.project.category_service.Service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	 @Autowired
	    private CategoryRepository categoryRepository;

	    @Override
	    public Category addCategory(Category category) {
	        return this.categoryRepository.save(category);
	    }

	    @Override
	    public Category updateCategory(Long id,Category category) throws Exception {
	        Optional<Category> category1=this.categoryRepository.findById(id);
	        if(category1.isPresent()){
	            Category category2=category1.get();
	            category2.setDescription(category.getDescription());
	            category2.setTitle(category.getTitle());
	            return this.categoryRepository.save(category2);
	        }
	        throw new Exception("Category not found!!");
	    }

	    @Override
	    public List<Category> getAllCategories() {
	        return this.categoryRepository.findAll();
	    }

	    @Override
	    public Category getCategoryById(Long categoryId) {
	        return this.categoryRepository.findById(categoryId).get();
	    }

	    @Override
	    public void deleteCategory(Long categoryId) {
	            Category category=new Category();
	            category.setCid(categoryId);
	            this.categoryRepository.delete(category);
	    }
}
