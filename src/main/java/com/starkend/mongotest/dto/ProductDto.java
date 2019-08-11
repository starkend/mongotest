package com.starkend.mongotest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {

    @JsonProperty("gtin14")
    private Long gtin14;

    @JsonProperty("brand_name")
    private String brandName;

    @JsonProperty("name")
    private String name;

    public Long getGtin14() {
        return gtin14;
    }

    public void setGtin14(Long gtin14) {
        this.gtin14 = gtin14;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
