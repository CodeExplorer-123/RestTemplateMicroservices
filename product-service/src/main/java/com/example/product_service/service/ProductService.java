package com.example.product_service.service;

import com.example.product_service.entity.Product;
import com.example.product_service.exception.ProductNotFoundException;
import com.example.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createproduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getProduct(Long id){
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("product is not found with given id :"  + id));
    }
}
