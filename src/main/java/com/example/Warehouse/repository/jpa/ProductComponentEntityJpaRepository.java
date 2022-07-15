package com.example.Warehouse.repository.jpa;

import com.example.Warehouse.repository.entity.ProductComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductComponentEntityJpaRepository extends JpaRepository<ProductComponentEntity, Integer> {
}
