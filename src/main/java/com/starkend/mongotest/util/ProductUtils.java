package com.starkend.mongotest.util;

import com.starkend.mongotest.dto.ProductDto;
import com.starkend.mongotest.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

public class ProductUtils {

    public static Product convertProductDtoToProduct(ProductDto dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return product;
    }

    public static ProductDto convertProductToProductDto(Product product) {
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }
}
