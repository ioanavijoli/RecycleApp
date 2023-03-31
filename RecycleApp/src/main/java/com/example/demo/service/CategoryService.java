package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.exception.CategoryAlreadyAddedException;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {
    ResponseEntity<?> addCategory(CategoryDto category)throws CategoryAlreadyAddedException;
    Category getCategoryByName(String name) throws CategoryNotFoundException;
    ResponseEntity<?> findCategory(String name) throws CategoryNotFoundException;
    void deleteCategory(Long id);
    ResponseEntity<?> updateCategory(CategoryDto categoryDt)throws CategoryAlreadyAddedException;
    ResponseEntity<?> getCategoryByCenterId(Long id) throws CategoryNotFoundException;
}
