package com.example.customer_service.service;

import com.example.customer_service.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceProxy {

    @Autowired
    private RestTemplate restTemplate;

    public List<Product> getAllProduct(){
        ResponseEntity<Product[]> responseOfGetAllProduct = restTemplate.getForEntity("http://localhost:8081/products/all", Product[].class);
        return Arrays.asList(Objects.requireNonNull(responseOfGetAllProduct.getBody()));
    }

//    public List<Product> getAllProduct() {
//        ResponseEntity<List<Product>> response = restTemplate.exchange(
//                "http://localhost:8081/products/all",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Product>>() {}
//        );
//        return response.getBody();
//    }


    public Product getProduct(Long id){
        ResponseEntity<Product> responseOfGetProduct = restTemplate.getForEntity("http://localhost:8081/products/id/{id}", Product.class, id);
        return responseOfGetProduct.getBody();
    }
}
