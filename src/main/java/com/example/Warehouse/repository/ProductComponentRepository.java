package com.example.Warehouse.repository;

import com.example.Warehouse.domain.ProductComponent;

import java.util.List;

public interface ProductComponentRepository {

    List<ProductComponent> findAll();
}
