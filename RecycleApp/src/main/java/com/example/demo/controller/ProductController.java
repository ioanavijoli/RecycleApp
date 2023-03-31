package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.exception.CategoryAlreadyAddedException;
import com.example.demo.exception.NoProductFoundException;
import com.example.demo.exception.ProductAlreadyAddedException;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/insertProduct")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDto productDto) throws ProductAlreadyAddedException {
        return productService.addProduct(productDto);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<?> findProductByName(@PathVariable String name) throws NoProductFoundException {

        return productService.findProducts(name);

    }

    @PostMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct(@Valid @RequestBody Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(new MessageResponse("Product removed successfully!"));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDto productDto) throws ProductAlreadyAddedException {
        productService.updateProduct(productDto);
        return ResponseEntity.ok(new MessageResponse("Product updated successfully!"));
    }

    @GetMapping("/getByCategoryId")
    public ResponseEntity<?> findProductsByCategoryId(@Valid @RequestBody Long id) throws NoProductFoundException {

        return productService.getProductsByCategoryId(id);

    }
}
