package com.starkend.mongotest.repository;

import com.starkend.mongotest.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
    public Product findByName(String name);
}
