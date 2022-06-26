package com.example.Warehouse.repository.jpa;

import com.example.Warehouse.utils.ProductComponentCsvImporter;
import com.example.Warehouse.utils.ProductCsvImporter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@RequiredArgsConstructor
class DatabaseLoader {

    @Value("${warehouse.componentCsv}")
    private String COMPONENTS_CSV;
    @Value("${warehouse.productCsv}")
    private String PRODUCT_CSV;
    private final ProductComponentCsvImporter productComponentCsvImporter;
    private final ProductCsvImporter productCsvImporter;

    @Bean
    CommandLineRunner initDatabase(ProductComponentEntityJpaRepository productComponentEntityJpaRepository,
                                   ProductEntityJpaRepository productEntityJpaRepository) {
        return args -> {
            log.info("initiating Database");
            final var productComponents = productComponentCsvImporter.importDataFromCsv(COMPONENTS_CSV);
            productComponentEntityJpaRepository.saveAll(productComponents);
            productEntityJpaRepository.saveAll(productCsvImporter.importDataFromCsv(PRODUCT_CSV, productComponents));
            log.info("Database initiated successfully");
        };
    }
}
