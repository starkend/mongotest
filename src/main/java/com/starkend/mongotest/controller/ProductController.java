package com.starkend.mongotest.controller;

import com.starkend.mongotest.model.Product;
import com.starkend.mongotest.service.ProductEgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    ProductEgressService productEgressService;

    @GetMapping("/productList")
    public List<Product> getProductList() {
        return productEgressService.getProductList();
    }

}
