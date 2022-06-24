/*
package com.example.Warehouse.utils;


import com.example.Warehouse.entity.ProductComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductComponentCsvImporterTest {

    final static String TEST_FILE = "src/test/java/resources/productComponentTestFile.csv";

    private ProductComponentCsvImporter productComponentCsvImporter;

    @BeforeEach
    void setup() {
        this.productComponentCsvImporter = new ProductComponentCsvImporter();
    }


    @Test
    void getAllComponentsFromCsvFile() {

        final List<ProductComponent> productComponentList =
                this.productComponentCsvImporter.importDataFromCsv(TEST_FILE);

        assertThat(productComponentList)
                .usingRecursiveComparison()
                .isEqualTo(getListOfTestComponents());

    }

    @Test()
    void expectEmptyListWhenReadingCsvFileThrowsIOException() {

        final List<ProductComponent> productComponentList =
                this.productComponentCsvImporter.importDataFromCsv("noFile");

        assertThat(productComponentList).isEmpty();
    }

    private List<ProductComponent> getListOfTestComponents() {

        return List.of(
                new ProductComponent()
                        .setName("Pineapple")
                        .setId(0)
                        .setPrice(1)
                        .setWeight(0)
                        .setColor("Yellow")
                        .setOrigin("Mexico")
                        .setAwesomeness(9)
                        .setFarmer("Alice")
                        .setOrganic(true)
                        .setCalories(50),
                new ProductComponent()
                        .setName("Banana")
                        .setId(1)
                        .setPrice(2)
                        .setWeight(9)
                        .setColor("Yellow")
                        .setOrigin("Brazil")
                        .setAwesomeness(7)
                        .setFarmer("Bob")
                        .setOrganic(false)
                        .setCalories(88),
                new ProductComponent()
                        .setName("Apple")
                        .setId(2)
                        .setPrice(3)
                        .setWeight(8)
                        .setColor("Red")
                        .setOrigin("France")
                        .setAwesomeness(6)
                        .setFarmer("Charlie")
                        .setOrganic(true)
                        .setCalories(52)
        );
    }
}
*/
