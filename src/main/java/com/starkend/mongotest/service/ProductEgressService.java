package com.starkend.mongotest.service;

import com.starkend.mongotest.dto.ProductDto;
import com.starkend.mongotest.model.Product;

import java.util.List;

public interface ProductEgressService {

    List<Product> getProductList();

    ProductDto addProduct(ProductDto productDto);

    Boolean deleteProduct(String productId);

    List<Product> queryByPartialName(String partialName);
}
