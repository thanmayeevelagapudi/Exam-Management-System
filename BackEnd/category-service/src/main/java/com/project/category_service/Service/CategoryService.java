package com.project.category_service.Service;

import java.util.List;

import com.project.category_service.Model.Category;

public interface CategoryService {
	public Category addCategory(Category category);
    public Category updateCategory(Long id,Category category) throws Exception;
    public List<Category> getAllCategories();
    public Category getCategoryById(Long categoryId);
    public void deleteCategory(Long categoryId);

}
