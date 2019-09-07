package com.starkend.mongotest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.starkend.mongotest.service.ProductEgressService;
import com.starkend.mongotest.service.ProductEgressServiceImpl;
import com.starkend.mongotest.service.ProductIngressService;
import com.starkend.mongotest.service.ProductIngressServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
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
    public MongoClient mongo() {
        return new MongoClient("localhost", 27017);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "mongodb");
    }

    @Bean
    public ProductIngressService productIngressService() {
        return new ProductIngressServiceImpl();
    }

    @Bean
    public ProductEgressService productEgressService() {
        return new ProductEgressServiceImpl();
    }

}
