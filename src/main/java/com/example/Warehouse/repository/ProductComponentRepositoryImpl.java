package com.example.Warehouse.repository;

import com.example.Warehouse.domain.ProductComponent;
import com.example.Warehouse.repository.jpa.ProductComponentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductComponentRepositoryImpl implements ProductComponentRepository {

    private final ProductComponentJpaRepository productComponentJpaRepository;

    @Override
    public List<ProductComponent> findAll() {
        return productComponentJpaRepository.findAll().stream()
                .map(ProductComponent::from)
                .collect(Collectors.toList());
    }
}
