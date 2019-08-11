package com.starkend.mongotest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starkend.mongotest.service.ProductService;
import com.starkend.mongotest.service.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.starkend.mongotest.repository"})
public class MongotestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongotestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public ProductService productService() { return new ProductServiceImpl(); }


}
