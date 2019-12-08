package com.starkend.mongotest.controller;

import com.starkend.mongotest.dto.ProductDto;
import com.starkend.mongotest.model.Product;
import com.starkend.mongotest.service.ProductEgressService;
import com.starkend.mongotest.service.ProductIngressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private ProductEgressService productEgressService;

    private ProductIngressService productIngressService;

    public ProductController(ProductEgressService productEgressService, ProductIngressService productIngressService) {
        this.productEgressService = productEgressService;
        this.productIngressService = productIngressService;
    }

    @GetMapping("/savedProductList")
    public ResponseEntity<List<Product>> getSavedProductList() {
        return new ResponseEntity<>(productEgressService.getProductList(), HttpStatus.OK);
    }

    @GetMapping("/apiProductList")
    public ResponseEntity<List<ProductDto>> getAPIProductList() {
        return new ResponseEntity<>(productIngressService.getItemsList(), HttpStatus.OK);
    }

    @PostMapping("/searchProducts")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestBody(required=false) String inputString) {
        return new ResponseEntity<>(productIngressService.getItemsByQuery(inputString), HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productEgressService.addProduct(productDto), HttpStatus.OK);
    }

    @PostMapping("/deleteProduct")
    public ResponseEntity<Boolean> deleteProduct(@RequestBody String productId) {
        return new ResponseEntity<>(productEgressService.deleteProduct(productId), HttpStatus.OK);
    }

    @PostMapping("/searchMongoByNameOrBrand")
    public ResponseEntity<List<Product>> searchMongoByNameOrBrand(@RequestBody String inputString) {
        return new ResponseEntity<>(productEgressService.searchByPartial(inputString), HttpStatus.OK);
    }
}
