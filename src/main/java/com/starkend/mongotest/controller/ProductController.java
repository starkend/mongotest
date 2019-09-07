package com.starkend.mongotest.controller;

import com.starkend.mongotest.dto.ProductDto;
import com.starkend.mongotest.model.Product;
import com.starkend.mongotest.service.ProductEgressService;
import com.starkend.mongotest.service.ProductIngressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    ProductEgressService productEgressService;

    @Autowired
    ProductIngressService productIngressService;

    @GetMapping("/savedProductList")
    public List<Product> getProductList() {
        return productEgressService.getProductList();
    }

    @GetMapping("/apiProductList")
    public List<ProductDto> getAPIProductList() {
        return productIngressService.getItemsList();
    }

    @PostMapping("/searchProducts")
    public List<ProductDto> searchProducts(@RequestBody String inputString) {
        return productIngressService.getItemsByQuery(inputString);
    }

    @PostMapping("/addProduct")
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return productEgressService.addProduct(productDto);
    }

    @PostMapping("/deleteProduct")
    public Boolean deleteProduct(@RequestBody String productId) {
        return productEgressService.deleteProduct(productId);
    }

    @PostMapping("/searchMongoByNameOrBrand")
    public List<Product> searchMongoByNameOrBrand(@RequestBody String inputString) {
        return productEgressService.searchByPartialNameOrBrand(inputString);
    }


}
