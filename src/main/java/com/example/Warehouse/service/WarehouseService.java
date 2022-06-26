package com.example.Warehouse.service;

import com.example.Warehouse.domain.DefaultProduct;
import com.example.Warehouse.domain.ProductComponent;
import com.example.Warehouse.repository.ProductComponentRepository;
import com.example.Warehouse.repository.DefaultProductRepository;
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


    public List<DefaultProduct> retrieveAllDefaultProducts() {
        log.info("retrieve All Default Products");
        return defaultProductRepository.findAll();
    }

    public List<ProductComponent> retrieveAllProductComponents() {
        log.info("retrieve All Product Components");
        return productComponentRepository.findAll();
    }
}


