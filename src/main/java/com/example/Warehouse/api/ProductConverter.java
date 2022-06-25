package com.example.Warehouse.api;

import com.example.Warehouse.api.dto.ProductResponse;
import com.example.Warehouse.domain.Product;
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
