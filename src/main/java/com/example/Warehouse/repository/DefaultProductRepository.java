package com.example.Warehouse.repository;


import com.example.Warehouse.entity.DefaultProduct;

import java.util.List;

public interface DefaultProductRepository {

    List<DefaultProduct> findAll();

}
