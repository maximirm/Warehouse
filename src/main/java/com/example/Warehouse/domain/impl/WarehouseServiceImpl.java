package com.example.Warehouse.domain.impl;


import com.example.Warehouse.domain.WarehouseService;
import com.example.Warehouse.entity.DefaultProduct;
import com.example.Warehouse.entity.ProductComponent;
import com.example.Warehouse.repository.DefaultProductRepository;
import com.example.Warehouse.repository.ProductComponentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final DefaultProductRepository defaultProductRepository;
    private final ProductComponentRepository productComponentRepository;

    @Override
    public List<DefaultProduct> getAllDefaultProducts() {
        return defaultProductRepository.findAll();
    }

    @Override
    public List<ProductComponent> getAllProductComponents() {
        return productComponentRepository.findAll();
    }
}


