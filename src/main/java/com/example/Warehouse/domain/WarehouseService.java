package com.example.Warehouse.domain;

import com.example.Warehouse.entity.DefaultProduct;
import com.example.Warehouse.entity.ProductComponent;

import java.util.List;

public interface WarehouseService {

    List<DefaultProduct> getAllDefaultProducts();

    List<ProductComponent> getAllProductComponents();
}
