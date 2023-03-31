package com.example.demo.service.impl;

import com.example.demo.dto.ProductDto;
import com.example.demo.exception.NoProductFoundException;
import com.example.demo.exception.ProductAlreadyAddedException;
import com.example.demo.model.Product;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<?> addProduct(ProductDto productDto) throws ProductAlreadyAddedException {
        if (productRepository.findByName(productDto.getName()) != null) {
            return ResponseEntity
                    .badRequest()
                    .body(new ProductAlreadyAddedException("Error: Product already added!"));
        }
        Product product=new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        productRepository.save(product);

        return ResponseEntity.ok(new MessageResponse("Product added successfully!"));
    }

    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }

    public void updateProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        productRepository.save(product);

    }

    public ResponseEntity<?> findProducts(String name) throws NoProductFoundException {
        List<Product> products = productRepository.findAllByNameContains(name);
        if (products.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new NoProductFoundException("Error: No products found!"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    public ResponseEntity<?> getProductsByCategoryId(Long id) throws NoProductFoundException {
        List<Product> products=productRepository.getAllByCategoryId(id);
        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).
                    body(new NoProductFoundException("Error: No products found!"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
