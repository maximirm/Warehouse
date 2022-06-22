package com.example.Warehouse.controller;

import com.example.Warehouse.controller.dto.ProductComponentResponse;
import com.example.Warehouse.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductComponentController {

    private final WarehouseService warehouseService;

    @GetMapping("/components")
    public List<ProductComponentResponse> getAllProductComponents() {

        log.info("retrieve all Product Components");
        return warehouseService
                .retrieveAllProductComponents()
                .stream()
                .map(ProductComponentConverter::toProductComponentResponse)
                .collect(Collectors.toList());
    }
}
