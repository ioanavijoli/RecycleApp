package com.example.demo.service.impl;

import com.example.demo.dto.CategoryDto;
import com.example.demo.exception.CategoryAlreadyAddedException;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.RecyclingCenter;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.RecyclingCenterRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    RecyclingCenterRepository recyclingCenterRepository;

    public ResponseEntity<?> addCategory(CategoryDto categoryDto) throws CategoryAlreadyAddedException {
        if (categoryRepository.findByName(categoryDto.getName()) != null) {
            throw new CategoryAlreadyAddedException("Category already added");
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setImageType(categoryDto.getImageType());
        categoryRepository.save(category);
        return ResponseEntity.ok(new MessageResponse("Category added successfully!"));
    }

    public Category getCategoryByName(String name) throws CategoryNotFoundException {
        Category category = categoryRepository.findByName(name);
        if (category == null) {
            throw new CategoryNotFoundException("Sorry! We didn't found this category");
        }
        return category;
    }

    public ResponseEntity<?> findCategory(String name) throws CategoryNotFoundException {
        List<Category> categories = categoryRepository.findAllByNameContains(name);
        if (categories.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new CategoryNotFoundException("Error: No Category found!"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public ResponseEntity<?> updateCategory(CategoryDto categoryDto) throws CategoryAlreadyAddedException {
        if (categoryRepository.findByName(categoryDto.getName()) != null) {
            throw new CategoryAlreadyAddedException("Sorry, this name is already used");
        }
        Category category=new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setImageType(categoryDto.getImageType());
        categoryRepository.save(category);
        return ResponseEntity.ok(new MessageResponse("Category added successfully!"));
    }

    public ResponseEntity<?> getCategoryByCenterId(Long id) throws CategoryNotFoundException {
        RecyclingCenter recyclingCenter= recyclingCenterRepository.findRecyclingCenterById(id);
     // List<Category> categories= categoryRepository.getCategoriesByRecyclingCenterListContaining(recyclingCenter);
        return ResponseEntity.ok(new MessageResponse("Category added successfully!"));
    }

}

