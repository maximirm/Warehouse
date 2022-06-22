package com.example.Warehouse.controller;

import com.example.Warehouse.controller.dto.ProductComponentResponse;
import com.example.Warehouse.entity.ProductComponent;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductComponentConverter {

    public static ProductComponentResponse toProductComponentResponse(ProductComponent productComponent) {
        return new ProductComponentResponse()
                .setId(productComponent.getId())
                .setName(productComponent.getName())
                .setAwesomeness(productComponent.getAwesomeness())
                .setCalories(productComponent.getCalories())
                .setColor(productComponent.getColor())
                .setFarmer(productComponent.getFarmer())
                .setOrigin(productComponent.getOrigin())
                .setPrice(productComponent.getPrice())
                .setOrganic(productComponent.isOrganic())
                .setWeight(productComponent.getWeight());
    }
}
