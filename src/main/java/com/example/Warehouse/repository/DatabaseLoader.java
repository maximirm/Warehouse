package com.example.Warehouse.repository;

import com.example.Warehouse.utils.ProductComponentCsvImporter;
import com.example.Warehouse.utils.ProductCsvImporter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@RequiredArgsConstructor
class DatabaseLoader {

    final static String COMPONENTS_CSV = "src/main/resources/components.csv";
    final static String PRODUCT_CSV = "src/main/resources/products.csv";
    private final ProductComponentCsvImporter productComponentCsvImporter;
    private final ProductCsvImporter productCsvImporter;

    @Bean
    CommandLineRunner initDatabase(ProductComponentRepository productComponentRepository,
                                   ProductRepository productRepository) {
        return args -> {
            log.info("initiating Database");
            final var productComponents = productComponentCsvImporter.importDataFromCsv(COMPONENTS_CSV);
            productComponentRepository.saveAll(productComponents);
            productRepository.saveAll(productCsvImporter.importDataFromCsv(PRODUCT_CSV, productComponents));
            log.info("Database initiated successfully");
        };
    }
}

