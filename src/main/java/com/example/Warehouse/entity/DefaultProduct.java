package com.example.Warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DefaultProduct {

    private int id;
    private String name;
    private List<ProductComponentEntity> components;

    public static DefaultProduct from(DefaultProductEntity defaultProductEntity) {
        return new DefaultProduct()
                .setId(defaultProductEntity.getId())
                .setName(defaultProductEntity.getName())
                .setComponents(defaultProductEntity.getComponents());
    }

}
