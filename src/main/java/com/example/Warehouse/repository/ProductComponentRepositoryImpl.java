package com.example.Warehouse.repository;

import com.example.Warehouse.domain.entity.ProductComponent;
import com.example.Warehouse.repository.jpa.ProductComponentEntityJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductComponentRepositoryImpl implements ProductComponentRepository {

    private final ProductComponentEntityJpaRepository productComponentEntityJpaRepository;

    @Cacheable(value="productComponentWarehouseCache")
    @Override
    public List<ProductComponent> findAll() {
        log.info("get product components from repo without cache");
        return productComponentEntityJpaRepository
                .findAll()
                .stream()
                .map(ProductComponent::from)
                .collect(Collectors.toList());
    }
}
