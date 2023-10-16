package com.example.springbootjdbctemplateexample.service;

import com.example.springbootjdbctemplateexample.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    void createProduct(Product product);

    void updateProduct(Integer id, Product product );

    void deleteProduct(Integer id);
}
