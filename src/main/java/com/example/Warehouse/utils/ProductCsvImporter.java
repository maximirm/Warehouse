package com.example.Warehouse.utils;

import com.example.Warehouse.entity.Product;
import com.example.Warehouse.entity.ProductComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ProductCsvImporter {

    public List<Product> importDataFromCsv(String fileName, List<ProductComponent> productComponents) {

        return importLinesFromCsv(fileName)
                .stream()
                .map(line -> createProduct(productComponents, line))
                .collect(Collectors.toList());
    }

    private Product createProduct(List<ProductComponent> productComponents, List<String> line) {
        return new Product()
                .setName(line.get(0))
                .setComponents(getComponents(line.get(1), productComponents));
    }

    private List<ProductComponent> getComponents(String lineOfRequiredComponents, List<ProductComponent> productComponents) {

        return Arrays
                .stream(lineOfRequiredComponents.split("-"))
                .map(componentId -> productComponents.get(Integer.parseInt(componentId)))
                .collect(Collectors.toList());
    }

    private List<List<String>> importLinesFromCsv(String fileName) {

        final List<List<String>> records = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            log.error("failed loading csv file in " + this.getClass());
            return Collections.emptyList();
        }
        return records;
    }
}
