package com.example.Warehouse.repository;

import com.example.Warehouse.domain.Product;
import com.example.Warehouse.repository.jpa.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll().stream()
                .map(Product::from)
                .collect(Collectors.toList());
    }
}
