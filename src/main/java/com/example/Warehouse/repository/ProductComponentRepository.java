package com.example.Warehouse.repository;

import com.example.Warehouse.repository.entity.ProductComponent;

import java.util.List;

public interface ProductComponentRepository {

    List<ProductComponent> findAll();
}
