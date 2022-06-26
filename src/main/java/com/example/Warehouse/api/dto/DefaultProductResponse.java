package com.example.Warehouse.api.dto;

import com.example.Warehouse.repository.jpa.ProductComponentEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class DefaultProductResponse {

    private UUID id;
    private String name;
    private List<ProductComponentEntity> components;

}
