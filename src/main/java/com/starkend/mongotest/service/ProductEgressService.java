package com.starkend.mongotest.service;

import com.starkend.mongotest.model.Product;

import java.util.List;

public interface ProductEgressService {

    List<Product> getProductList();
}
