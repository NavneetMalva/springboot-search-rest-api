package com.springboot.search.controller;

import com.springboot.search.entity.Product;
import com.springboot.search.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productservice;
    // constructor based Dependency Injection
    public ProductController(ProductService productservice) {
        this.productservice = productservice;
    }

    @GetMapping
    public String helloWorld(){
        return "Welcome to SpringBoot search api";
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam("query") String query) {
        return ResponseEntity.ok(productservice.searchProducts(query));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productservice.createProduct(product);
    }
}
