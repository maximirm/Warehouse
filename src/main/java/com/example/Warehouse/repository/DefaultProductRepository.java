package com.example.Warehouse.repository;

import com.example.Warehouse.domain.DefaultProduct;

import java.util.List;

public interface DefaultProductRepository {

    List<DefaultProduct> findAll();

}
