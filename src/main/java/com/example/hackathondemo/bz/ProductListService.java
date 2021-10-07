package com.example.hackathondemo.bz;

import com.example.hackathondemo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductListService {

    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("B2 - Cloud Storage"));
        productList.add(new Product("B1 - Computer Backup"));
    }

    public List<Product> findAll() {
        return productList;
    }

}
