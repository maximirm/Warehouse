package com.example.Warehouse.api.dto;

import com.example.Warehouse.entity.DefaultProduct;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
public class DefaultProductResponse {

    private int id;
    private String name;
    private List<ProductComponentResponse> components;

    public static DefaultProductResponse from(DefaultProduct defaultProduct) {
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
