package com.example.Warehouse.domain;


import com.example.Warehouse.domain.entity.DefaultProduct;
import com.example.Warehouse.domain.entity.ProductComponent;
import com.example.Warehouse.repository.DefaultProductRepository;
import com.example.Warehouse.repository.ProductComponentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final DefaultProductRepository defaultProductRepository;
    private final ProductComponentRepository productComponentRepository;

    public List<DefaultProduct> getAllDefaultProducts() {
        log.info("retrieve All Default Products from database");
        return defaultProductRepository.findAll();
    }

    public List<ProductComponent> getAllProductComponents() {
        log.info("retrieve All Product Components from database");
        return productComponentRepository.findAll();
    }
}


