package com.openclassrooms.datalayer.service;

import com.openclassrooms.datalayer.model.Category;
import com.openclassrooms.datalayer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }


}
