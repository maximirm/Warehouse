package com.example.Warehouse.utils;

import com.example.Warehouse.repository.jpa.DefaultProductEntity;
import com.example.Warehouse.repository.jpa.ProductComponentEntity;
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
public class DefaultProductCsvImporter {

    public List<DefaultProductEntity> importDataFromCsv(String fileName, List<ProductComponentEntity> productComponentEntities) {

        return importLinesFromCsv(fileName)
                .stream()
                .map(line -> createProduct(productComponentEntities, line))
                .collect(Collectors.toList());
    }

    private DefaultProductEntity createProduct(List<ProductComponentEntity> productComponentEntities, List<String> line) {
        return new DefaultProductEntity()
                .setId(Integer.parseInt(line.get(0)))
                .setName(line.get(1))
                .setComponents(getComponents(line.get(2), productComponentEntities));
    }

    private List<ProductComponentEntity> getComponents(String lineOfRequiredComponents, List<ProductComponentEntity> productComponentEntities) {

        return Arrays
                .stream(lineOfRequiredComponents.split("-"))
                .map(componentId -> productComponentEntities.get(Integer.parseInt(componentId)))
                .collect(Collectors.toList());
    }

    private List<List<String>> importLinesFromCsv(String fileName) {

        var records = new ArrayList<List<String>>();
        try {
            var br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("failed loading csv file in " + this.getClass());
            return Collections.emptyList();
        }
        return records;
    }
}
