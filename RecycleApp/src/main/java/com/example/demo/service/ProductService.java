package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.exception.NoProductFoundException;
import com.example.demo.exception.ProductAlreadyAddedException;
import com.example.demo.model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> addProduct(ProductDto productDto) throws ProductAlreadyAddedException;

    void deleteProduct(Long id);

    void updateProduct(ProductDto product);

    ResponseEntity<?> findProducts(String name) throws NoProductFoundException;
    ResponseEntity<?> getProductsByCategoryId(Long id) throws NoProductFoundException;
}
