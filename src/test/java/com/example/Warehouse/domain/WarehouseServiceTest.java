package com.example.Warehouse.domain;

import com.example.Warehouse.repository.DefaultProductRepository;
import com.example.Warehouse.repository.ProductComponentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WarehouseServiceTest {

    @InjectMocks
    private WarehouseService warehouseService;
    @Mock
    private DefaultProductRepository defaultProductRepository;
    @Mock
    private ProductComponentRepository productComponentRepository;

    @Test
    void retrieveAllDefaultProducts() {
        warehouseService.getAllDefaultProducts();

        verify(defaultProductRepository, times(1)).findAll();
    }

    @Test
    void retrieveAllProductComponents() {
        warehouseService.getAllProductComponents();

        verify(productComponentRepository, times(1)).findAll();
    }
}
