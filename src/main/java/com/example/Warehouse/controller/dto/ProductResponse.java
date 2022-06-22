package com.example.Warehouse.controller.dto;

import com.example.Warehouse.entity.ProductComponent;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ProductResponse {

    private UUID id;
    private String name;
    private List<ProductComponent> components;

}
