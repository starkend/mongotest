package com.starkend.mongotest.service;

import com.starkend.mongotest.MongotestApplication;
import com.starkend.mongotest.model.Product;
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
public class ProductEgressServiceImplTest {

    @Autowired
    ProductEgressService productEgressService;

    @Test
    public void whenGetProductList_thenReturnPopulatedProductList() {
        List<Product> productList = productEgressService.getProductList();

        assertNotNull(productList);

        assertFalse(productList.isEmpty());
    }

    @Test
    public void whenSearchByPartialName_thenReturnMatchingProducts() {
        List<Product> productList = productEgressService.searchByPartialName("Crust");

        assertNotNull(productList);
        assertFalse(productList.isEmpty());
    }

    @Test
    public void whenSearchByPartialBrandName_thenReturnMatchingProducts() {
        List<Product> productList = productEgressService.searchByPartialBrandName("Country");

        assertNotNull(productList);
        assertFalse(productList.isEmpty());
    }

    @Test
    public void whenSearchByPartialBrandOrName_thenReturnMatchingProducts() {
        List<Product> productList = productEgressService.searchByPartialNameOrBrand("Syrup");

        assertNotNull(productList);
        assertFalse(productList.isEmpty());
    }
}
