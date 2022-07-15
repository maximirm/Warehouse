package com.example.Warehouse.repository.impl;

import com.example.Warehouse.repository.ProductComponentRepository;
import com.example.Warehouse.repository.entity.ProductComponentEntity;
import com.example.Warehouse.repository.jpa.ProductComponentEntityJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductComponentRepositoryImpl implements ProductComponentRepository {

    private final ProductComponentEntityJpaRepository productComponentEntityJpaRepository;

    @Override
    public List<ProductComponentEntity> findAll() {
        return productComponentEntityJpaRepository.findAll();
    }
}
