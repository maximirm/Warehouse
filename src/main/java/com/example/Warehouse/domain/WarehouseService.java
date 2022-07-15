package com.example.Warehouse.domain;

import com.example.Warehouse.repository.entity.DefaultProduct;
import com.example.Warehouse.repository.entity.ProductComponent;

import java.util.List;

public interface WarehouseService {

    List<DefaultProduct> getAllDefaultProducts();

    List<ProductComponent> getAllProductComponents();
}
