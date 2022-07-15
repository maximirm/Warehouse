package com.example.Warehouse.domain.impl;


import com.example.Warehouse.domain.WarehouseService;
import com.example.Warehouse.domain.entity.DefaultProduct;
import com.example.Warehouse.domain.entity.ProductComponent;
import com.example.Warehouse.repository.DefaultProductRepository;
import com.example.Warehouse.repository.ProductComponentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final DefaultProductRepository defaultProductRepository;
    private final ProductComponentRepository productComponentRepository;

    @Cacheable(value = "defaultProductCache")
    @Override
    public List<DefaultProduct> getAllDefaultProducts() {
        log.info("retrieve All Default Products from database without cache");
        return defaultProductRepository
                .findAll()
                .stream()
                .map(DefaultProduct::from)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "productComponentCache")
    @Override
    public List<ProductComponent> getAllProductComponents() {
        log.info("retrieve All Product Components from database without cache");
        return productComponentRepository
                .findAll()
                .stream()
                .map(ProductComponent::from)
                .collect(Collectors.toList());
    }
}


