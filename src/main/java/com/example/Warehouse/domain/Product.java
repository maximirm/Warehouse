package com.example.Warehouse.domain;

import com.example.Warehouse.repository.jpa.ProductComponentEntity;
import com.example.Warehouse.repository.jpa.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Product {

    private UUID id;
    private String name;
    private List<ProductComponentEntity> components;

    public static Product from(ProductEntity productEntity) {
        return new Product()
                .setId(productEntity.getId())
                .setName(productEntity.getName())
                .setComponents(productEntity.getComponents());
    }

}
