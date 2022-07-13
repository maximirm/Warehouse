package com.example.Warehouse.api;

import com.example.Warehouse.domain.WarehouseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ControllerTest {

    @InjectMocks
    private Controller controller;
    @Mock
    private WarehouseService warehouseService;

    @Test
    void retrieveAllProducts() {

        controller.getAllDefaultProducts();

        verify(warehouseService).getAllDefaultProducts();
    }

    @Test
    void getAllProductComponents() {

        controller.getAllProductComponents();

        verify(warehouseService).getAllProductComponents();

    }
}
