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
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongotestApplication.class)
public class ProductIngressServiceImplTest {

    @Autowired
    ProductIngressService productIngressService;

    @Test
    public void whenGetItems_thenReturnPopulatedItemsList() {
        List<ProductDto> productList = productIngressService.getItemsList();

        assertNotNull(productList);
        assertFalse(productList.isEmpty());

        productList.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void whenSearchBySingleWord_thenReturnPopulatedItemsList() {
        String queryString = "peanut";
        List<ProductDto> productList = productIngressService.getItemsByQuery(queryString);

        assertNotNull(productList);
        assertFalse(productList.isEmpty());
    }

    @Test
    public void whenSearchByMultipleWords_thenReturnPopulatedItemsList() {
        String queryString = "peanut butter";
        List<ProductDto> productList = productIngressService.getItemsByQuery(queryString);

        assertNotNull(productList);
        assertFalse(productList.isEmpty());
        productList.forEach(p -> System.out.println(p.getName()));
    }

}
