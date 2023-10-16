package com.example.springbootjdbctemplateexample.service.impl;

import com.example.springbootjdbctemplateexample.entity.Product;
import com.example.springbootjdbctemplateexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private JdbcTemplate    jdbcTemplate;

     RowMapper  rowMapper  = (rs,rowNum)->new Product(
             rs.getInt("id"),
             rs.getString("name"),
             rs.getDouble("price"),
             rs.getInt("quantity"));

    @Override
    public List<Product> getProducts() {
        var sql  = "SELECT * FROM product_table";
       return jdbcTemplate.query(sql,rowMapper);

    }

    @Override
    public void createProduct(Product product) {
     var sql  = "insert into product_table (id, name, price, quantity) values (?,?,?,?)";
      jdbcTemplate.update(sql,product.getId(),product.getName(),product.getPrice(),product.getQuantity());
    }

    @Override
    public void updateProduct(Integer id, Product product) {
        var sql = "update product_table set  name = ?, price = ?, quantity =? where id = ?";
        jdbcTemplate.update(sql,product.getName(),product.getPrice(),product.getQuantity(),id);
    }

    @Override
    public void deleteProduct(Integer id) {
     var sql = "delete from product_table where id = ?";
     jdbcTemplate.update(sql,id);
    }
}
