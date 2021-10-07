package com.example.hackathondemo.controller;

import com.example.hackathondemo.service.ProductListService;
import com.example.hackathondemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class ProductResource {

    @Autowired
    private ProductListService productListService;

    @GetMapping("/bz/products")
    public List<Product> getAllProducts() {
        return productListService.findAll();
    }

}
