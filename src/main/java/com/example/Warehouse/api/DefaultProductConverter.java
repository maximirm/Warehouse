package com.example.Warehouse.api;

import com.example.Warehouse.entity.DefaultProductResponse;
import com.example.Warehouse.entity.ProductComponentResponse;
import com.example.Warehouse.entity.DefaultProduct;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

@UtilityClass
public class DefaultProductConverter {

    public static DefaultProductResponse toProductResponse(DefaultProduct defaultProduct) {
        return new DefaultProductResponse()
                .setId(defaultProduct.getId())
                .setName(defaultProduct.getName())
                .setComponents(defaultProduct.getComponents()
                        .stream()
                        .map(ProductComponentResponse::from)
                        .collect(Collectors.toList())
                );
    }
}
