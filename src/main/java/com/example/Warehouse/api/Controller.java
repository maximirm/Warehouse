package com.example.Warehouse.api;

import com.example.Warehouse.api.dto.DefaultProductResponse;
import com.example.Warehouse.api.dto.ProductComponentResponse;
import com.example.Warehouse.domain.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final WarehouseService warehouseService;

    @GetMapping("/defaultProducts")
    @ResponseStatus(OK)
    public List<DefaultProductResponse> getAllDefaultProducts() {
        return warehouseService.getAllDefaultProducts()
                .stream()
                .map(DefaultProductResponse::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/components")
    @ResponseStatus(OK)
    public List<ProductComponentResponse> getAllProductComponents() {

        return warehouseService
                .getAllProductComponents()
                .stream()
                .map(ProductComponentResponse::from)
                .collect(Collectors.toList());
    }
}
