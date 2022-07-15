package com.example.Warehouse.repository;

import com.example.Warehouse.repository.entity.ProductComponentEntity;

import java.util.List;

public interface ProductComponentRepository {

    List<ProductComponentEntity> findAll();
}
