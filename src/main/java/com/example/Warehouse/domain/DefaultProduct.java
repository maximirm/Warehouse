package com.example.Warehouse.domain;

import com.example.Warehouse.repository.jpa.ProductComponentEntity;
import com.example.Warehouse.repository.jpa.DefaultProductEntity;
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
public class DefaultProduct {

    private UUID id = UUID.randomUUID();
    private String name;
    private List<ProductComponentEntity> components;

    public static DefaultProduct from(DefaultProductEntity defaultProductEntity) {
        return new DefaultProduct()
                .setId(UUID.randomUUID())
                .setName(defaultProductEntity.getName())
                .setComponents(defaultProductEntity.getComponents());
    }

}
