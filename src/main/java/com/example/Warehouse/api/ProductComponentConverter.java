package com.example.Warehouse.api;

import com.example.Warehouse.api.dto.ProductComponentResponse;
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
