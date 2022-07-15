package com.example.Warehouse.repository;

import com.example.Warehouse.repository.entity.DefaultProductEntity;

import java.util.List;

public interface DefaultProductRepository {

    List<DefaultProductEntity> findAll();
}
