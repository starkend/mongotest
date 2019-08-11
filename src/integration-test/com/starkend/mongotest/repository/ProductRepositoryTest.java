package com.starkend.mongotest.repository;

import com.starkend.mongotest.MongotestApplication;
import com.starkend.mongotest.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongotestApplication.class)
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void whenTestInsertProductIntoMongodb_thenSucceed() {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setBrandName("Test Brand");
        product.setName("Test Name");
        product.setGtin14(1000L);

        productRepository.insert(product);

        Object findProduct = productRepository.findByName(product.getName());

        assertNotNull(findProduct);
    }
}
