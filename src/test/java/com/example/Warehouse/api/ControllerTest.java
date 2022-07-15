package com.example.Warehouse.api;

import com.example.Warehouse.domain.impl.WarehouseServiceImpl;
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
    private WarehouseServiceImpl warehouseServiceImpl;

    @Test
    void retrieveAllProducts() {

        controller.getAllDefaultProducts();

        verify(warehouseServiceImpl).getAllDefaultProducts();
    }

    @Test
    void getAllProductComponents() {

        controller.getAllProductComponents();

        verify(warehouseServiceImpl).getAllProductComponents();
    }
}
