package com.example.Warehouse.service;

import com.example.Warehouse.entity.Product;
import com.example.Warehouse.entity.ProductComponent;
import com.example.Warehouse.repository.ProductComponentRepository;
import com.example.Warehouse.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final ProductRepository productRepository;
    private final ProductComponentRepository productComponentRepository;


    public List<Product> retrieveAllProducts() {
        log.info("retrieve All Products");
        return productRepository.findAll();
    }

    public List<ProductComponent> retrieveAllProductComponents() {
        log.info("retrieve All Product Components");
        return productComponentRepository.findAll();
    }
}


