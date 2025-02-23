package com.springboot.search.controller;

import com.springboot.search.domain.ResponseDomain;
import com.springboot.search.entity.Product;
import com.springboot.search.service.ProductService;
import com.springboot.search.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productservice;

    @GetMapping
    public ResponseEntity<ResponseDomain> helloWorld() {
        return new ResponseEntity<>(ResponseUtil.populateSuccessResponseDomain("Welcome to SpringBoot search api"), HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<ResponseDomain> searchProduct(@RequestParam("query") String query) {
        List<Product> products = productservice.searchProducts(query);
        if(products.isEmpty()){
            return new ResponseEntity<>(ResponseUtil.populateSuccessResponseDomain(null, "No Product found with query : "+  query), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResponseUtil.populateSuccessResponseDomain(products, "List of Products retrieved successfully."), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDomain> createProduct(@RequestBody Product product) {
        Product response = productservice.createProduct(product);
        return new ResponseEntity<>(ResponseUtil.populateSuccessResponseDomain(response, "Product created Successfully !!"), HttpStatus.CREATED);
    }
}
