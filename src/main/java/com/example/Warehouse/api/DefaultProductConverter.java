package com.example.Warehouse.api;

import com.example.Warehouse.api.dto.DefaultProductResponse;
import com.example.Warehouse.domain.DefaultProduct;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DefaultProductConverter {

    public static DefaultProductResponse toProductResponse(DefaultProduct defaultProduct) {
        return new DefaultProductResponse()
                .setId(defaultProduct.getId())
                .setName(defaultProduct.getName())
                .setComponents(defaultProduct.getComponents());
    }
}
