package com.example.Warehouse.repository;

import com.example.Warehouse.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

}
