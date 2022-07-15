package com.example.Warehouse.api;


import com.example.Warehouse.domain.impl.WarehouseServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Controller.class)
public class ControllerTestIT {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WarehouseServiceImpl warehouseServiceImpl;

    @Test
    void get_all_default_products() {
        try {
            mockMvc.perform(get("/defaultProducts"))
                    .andExpect(status().isOk());

            verify(warehouseServiceImpl).getAllDefaultProducts();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void get_all_product_components() {
        try {
            mockMvc.perform(get("/components"))
                    .andExpect(status().isOk());

            verify(warehouseServiceImpl).getAllProductComponents();
        } catch (Exception e) {
            fail();
        }
    }
}
