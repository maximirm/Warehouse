package com.example.Warehouse.api;

import com.example.Warehouse.api.dto.DefaultProductResponse;
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
public class DefaultProductController {

    private final WarehouseService warehouseService;

    @GetMapping("/defaultProducts")
    public List<DefaultProductResponse> retrieveAllProducts() {
        log.info("retrieve all Default Products");
        return warehouseService.retrieveAllDefaultProducts()
                .stream()
                .map(DefaultProductConverter::toProductResponse)
                .collect(Collectors.toList());
    }
}
