package com.starkend.mongotest.service;

import com.starkend.mongotest.dto.ProductDto;

import java.util.List;

public interface ProductIngressService {

    List<ProductDto> getItemsList();

    List<ProductDto> getItemsByQuery(String queryString);
}
