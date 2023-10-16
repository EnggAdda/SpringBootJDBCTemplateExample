package com.example.springbootjdbctemplateexample.controller;

import com.example.springbootjdbctemplateexample.entity.Product;
import com.example.springbootjdbctemplateexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    List<Product> getAllProducts(){
       return productService.getProducts();
    }

    @PostMapping("/insertProduct")
    void insert(@RequestBody Product product){

         productService.createProduct(product);
    }

    @PutMapping("/updateProduct/{id}")
    void update(@PathVariable Integer id ,@RequestBody Product product){
        productService.updateProduct(id,product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    void delete(@PathVariable Integer id ){
        productService.deleteProduct(id);
    }

}
