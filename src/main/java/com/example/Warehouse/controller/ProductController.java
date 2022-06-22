package com.example.Warehouse.controller;

import com.example.Warehouse.controller.dto.ProductResponse;
import com.example.Warehouse.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final WarehouseService warehouseService;

    @GetMapping("/products")
    public List<ProductResponse> retrieveAllProducts() {
        log.info("retrieve all Products");
        return warehouseService.retrieveAllProducts()
                .stream()
                .map(ProductConverter::toProductResponse)
                .collect(Collectors.toList());
    }
}
