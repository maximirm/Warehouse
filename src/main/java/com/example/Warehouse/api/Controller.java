package com.example.Warehouse.api;

import com.example.Warehouse.api.dto.DefaultProductResponse;
import com.example.Warehouse.api.dto.ProductComponentResponse;
import com.example.Warehouse.domain.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.ResponseEntity.status;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final WarehouseService warehouseService;

    @GetMapping("/defaultProducts")
    @ResponseStatus(OK)
    public ResponseEntity<List<DefaultProductResponse>> getAllDefaultProducts() {

        var defaultProducts = warehouseService
                .getAllDefaultProducts()
                .stream()
                .map(DefaultProductResponse::from)
                .collect(Collectors.toList());

        return status(OK).body(defaultProducts);
    }

    @GetMapping("/components")
    @ResponseStatus(OK)
    public ResponseEntity<List<ProductComponentResponse>> getAllProductComponents() {
        var productComponents = warehouseService
                .getAllProductComponents()
                .stream()
                .map(ProductComponentResponse::from)
                .collect(Collectors.toList());

        return status(OK).body(productComponents);
    }
}
