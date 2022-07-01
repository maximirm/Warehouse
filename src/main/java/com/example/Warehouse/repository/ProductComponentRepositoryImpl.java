package com.example.Warehouse.repository;

import com.example.Warehouse.entity.ProductComponent;
import com.example.Warehouse.repository.jpa.ProductComponentEntityJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductComponentRepositoryImpl implements ProductComponentRepository {

    private final ProductComponentEntityJpaRepository productComponentEntityJpaRepository;

    @Override
    public List<ProductComponent> findAll() {
        return productComponentEntityJpaRepository.findAll().stream()
                .map(ProductComponent::from)
                .collect(Collectors.toList());
    }
}
