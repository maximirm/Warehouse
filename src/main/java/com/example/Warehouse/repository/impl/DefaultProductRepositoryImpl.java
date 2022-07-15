package com.example.Warehouse.repository.impl;

import com.example.Warehouse.domain.entity.DefaultProduct;
import com.example.Warehouse.repository.DefaultProductRepository;
import com.example.Warehouse.repository.entity.DefaultProductEntity;
import com.example.Warehouse.repository.jpa.DefaultProductEntityJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DefaultProductRepositoryImpl implements DefaultProductRepository {

    private final DefaultProductEntityJpaRepository defaultProductEntityJpaRepository;

    @Cacheable(value = "userProductWarehouseCache")
    @Override
    public List<DefaultProductEntity> findAll() {
        log.info("get default products from repo without cache");
        return defaultProductEntityJpaRepository.findAll();
    }
}
