package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.exception.CategoryAlreadyAddedException;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/insertCategory")
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryDto categoryDto) throws CategoryAlreadyAddedException {
        return categoryService.addCategory(categoryDto);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<?> findCategory(@PathVariable String name) throws CategoryNotFoundException {
        return categoryService.findCategory(name);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteCategory(@Valid @RequestBody Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new MessageResponse("Category removed successfully!"));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCategory(@Valid @RequestBody CategoryDto categoryDto) throws CategoryAlreadyAddedException {
        categoryService.updateCategory(categoryDto);
        return ResponseEntity.ok(new MessageResponse("Category updated successfully!"));
    }

    @GetMapping("/getCategoriesByCenterId")
    public ResponseEntity<?> getCategoriesByCenterId(@Valid @RequestBody Long id) throws CategoryNotFoundException {
       // return categoryService.getCategoryByCenterId(id);
        return ResponseEntity.ok(new MessageResponse("Category updated successfully!"));
    }

}

