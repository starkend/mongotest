package com.starkend.mongotest.service;

import com.starkend.mongotest.MongotestApplication;
import com.starkend.mongotest.dto.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongotestApplication.class)
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    public void whenGetItems_thenReturnPopulatedItemsList() {
        List<ProductDto> productList = productService.getItemsList();

        assertFalse(productList.isEmpty());

        productList.forEach(p -> System.out.println(p.getName()));
    }
}
