package com.example.Warehouse.repository.jpa;

import com.example.Warehouse.domain.entity.DefaultProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultProductEntityJpaRepository extends JpaRepository<DefaultProductEntity, Integer> {
}
