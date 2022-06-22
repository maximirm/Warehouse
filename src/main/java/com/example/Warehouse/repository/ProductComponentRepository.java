package com.example.Warehouse.repository;

import com.example.Warehouse.entity.ProductComponent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductComponentRepository extends JpaRepository<ProductComponent, Long> {
}
