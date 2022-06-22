package com.example.Warehouse.controller;

import com.example.Warehouse.controller.dto.ProductResponse;
import com.example.Warehouse.entity.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductConverter {

    public static ProductResponse toProductResponse(Product product) {
        return new ProductResponse()
                .setId(product.getId())
                .setName(product.getName())
                .setComponents(product.getComponents());
    }
}
