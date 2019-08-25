package com.starkend.mongotest.service;

import com.starkend.mongotest.dto.ProductDto;
import com.starkend.mongotest.model.Product;
import com.starkend.mongotest.repository.ProductRepository;
import com.starkend.mongotest.util.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductEgressServiceImpl implements ProductEgressService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MongoTemplate mongoTemplate;

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

    @Override
    public Boolean deleteProduct(String productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public List<Product> searchByPartialName(String partialName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(partialName));

        List<Product> productList = mongoTemplate.find(query, Product.class);
        Collections.sort(productList);

        return productList;
    }

    @Override
    public List<Product> searchByPartialBrandName(String partialBrandName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("brandName").regex(partialBrandName));

        List<Product> productList = mongoTemplate.find(query, Product.class);
        Collections.sort(productList);

        return productList;
    }
}
