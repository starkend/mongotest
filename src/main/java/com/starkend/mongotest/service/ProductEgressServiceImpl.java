package com.starkend.mongotest.service;

import com.starkend.mongotest.dto.ProductDto;
import com.starkend.mongotest.model.Product;
import com.starkend.mongotest.repository.ProductRepository;
import com.starkend.mongotest.util.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductEgressServiceImpl implements ProductEgressService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProductList() {
        Iterable<Product> productIterable = productRepository.findAll();

        return StreamSupport.stream(productIterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product saveProduct = ProductUtils.convertProductDtoToProduct(productDto);
        Product returnProduct = productRepository.insert(saveProduct);
        return ProductUtils.convertProductToProductDto(returnProduct);
    }
}
