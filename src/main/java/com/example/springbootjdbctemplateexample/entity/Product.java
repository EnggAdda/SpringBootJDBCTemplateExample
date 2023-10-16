package com.example.springbootjdbctemplateexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product_table")
public class Product {

    private Integer id ;
    private String name ;

    private Double price;

    private Integer quantity;
}
