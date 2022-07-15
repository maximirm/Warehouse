package com.example.Warehouse.repository.impl;

import com.example.Warehouse.repository.DefaultProductRepository;
import com.example.Warehouse.repository.entity.DefaultProductEntity;
import com.example.Warehouse.repository.jpa.DefaultProductEntityJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DefaultProductRepositoryImpl implements DefaultProductRepository {

    private final DefaultProductEntityJpaRepository defaultProductEntityJpaRepository;

    @Override
    public List<DefaultProductEntity> findAll() {
        return defaultProductEntityJpaRepository.findAll();
    }
}
