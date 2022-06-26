package com.example.Warehouse.repository;

import com.example.Warehouse.domain.DefaultProduct;
import com.example.Warehouse.repository.jpa.DefaultProductEntityJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DefaultProductRepositoryImpl implements DefaultProductRepository {

    private final DefaultProductEntityJpaRepository defaultProductEntityJpaRepository;

    @Override
    public List<DefaultProduct> findAll() {
        return defaultProductEntityJpaRepository.findAll().stream()
                .map(DefaultProduct::from)
                .collect(Collectors.toList());
    }
}
