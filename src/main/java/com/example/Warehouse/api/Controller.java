package com.example.Warehouse.api;

import com.example.Warehouse.api.dto.DefaultProductResponse;
import com.example.Warehouse.api.dto.ProductComponentResponse;
import com.example.Warehouse.domain.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final WarehouseService warehouseService;

    @GetMapping("/defaultProducts")
    public List<DefaultProductResponse> retrieveAllProducts() {
        return warehouseService.retrieveAllDefaultProducts()
                .stream()
                .map(DefaultProductResponse::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/components")
    public List<ProductComponentResponse> getAllProductComponents() {

        return warehouseService
                .retrieveAllProductComponents()
                .stream()
                .map(ProductComponentResponse::from)
                .collect(Collectors.toList());
    }
}
