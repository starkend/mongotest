package com.starkend.mongotest.util;

import com.starkend.mongotest.dto.ProductDto;
import com.starkend.mongotest.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductUtilsTest {

    @Test
    public void whenConvertDtoToProduct_thenReturnPopulatedProduct() {
        ProductDto dto = new ProductDto();

        dto.setGtin14(500L);
        dto.setBrandName("Test Brand");
        dto.setName("Test Name");
        dto.setCalories("300");
        dto.setCarbohydrate("30g");
        dto.setFat("10g");
        dto.setProtein("20g");
        dto.setTransFat("0g");
        dto.setPolyunsaturatedFat("4g");
        dto.setMonounsaturatedFat("5g");
        dto.setCholesterol("3");
        dto.setFiber("4g");
        dto.setFatCalories("90");
        dto.setSaturatedFat("1g");
        dto.setIngredients("Glycerin, Yellow 5, Pressed Peanut Sweepings");
        dto.setSize("10");
        dto.setSugars("10g");
        dto.setSodium("100mg");
        dto.setServingsPerContainer("5");
        dto.setServingSize("100g");
        dto.setPotassium("50mg");
        dto.setAlcoholByVolume("0");

        Product product = ProductUtils.convertProductDtoToProduct(dto);

        assertNotNull(product);
        assertNotNull(product.getBrandName());
        assertNotNull(product.getName());
    }
}
