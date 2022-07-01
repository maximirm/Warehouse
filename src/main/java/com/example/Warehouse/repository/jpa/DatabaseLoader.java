package com.example.Warehouse.repository.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Configuration
@RequiredArgsConstructor
class DatabaseLoader {

    private final ProductComponentCsvImporter productComponentCsvImporter;
    private final DefaultProductCsvImporter defaultProductCsvImporter;

    @Value("${warehouse.componentCsv}")
    private String COMPONENTS_CSV;
    @Value("${warehouse.productCsv}")
    private String PRODUCT_CSV;

    @Bean
    CommandLineRunner initDatabase(ProductComponentEntityJpaRepository productComponentEntityJpaRepository,
                                   DefaultProductEntityJpaRepository defaultProductEntityJpaRepository) {
        return args -> {
            log.info("initiating Database");

            var productComponentsFromCsv = productComponentCsvImporter.importDataFromCsv(COMPONENTS_CSV);
            var productComponentsWithoutDuplicates = removeDuplicates(productComponentEntityJpaRepository, productComponentsFromCsv);
            productComponentEntityJpaRepository.saveAll(productComponentsWithoutDuplicates);

            var defaultProductEntities = defaultProductCsvImporter.importDataFromCsv(PRODUCT_CSV, productComponentsFromCsv);
            var defaultProductEntitiesWithoutDuplicates = removeDuplicates(defaultProductEntityJpaRepository, defaultProductEntities);
            defaultProductEntityJpaRepository.saveAll(defaultProductEntitiesWithoutDuplicates);

            log.info("Database initiated successfully");
        };
    }

    private List<ProductComponentEntity> removeDuplicates(ProductComponentEntityJpaRepository repository, List<ProductComponentEntity> jpaEntities) {

        var idsOfPresentEntities = getIdsOfPresentEntities(repository);

        return jpaEntities.stream()
                .filter(p -> !idsOfPresentEntities.contains(p.getId()))
                .collect(Collectors.toList());
    }

    private List<DefaultProductEntity> removeDuplicates(DefaultProductEntityJpaRepository repository, List<DefaultProductEntity> jpaEntities) {

        var idsOfPresentEntities = getIdsOfPresentEntities(repository);

        return jpaEntities.stream()
                .filter(p -> !idsOfPresentEntities.contains(p.getId()))
                .collect(Collectors.toList());
    }

    private List<Integer> getIdsOfPresentEntities(ProductComponentEntityJpaRepository repository) {
        return repository
                .findAll()
                .stream()
                .map(ProductComponentEntity::getId)
                .collect(Collectors.toList());
    }

    private List<Integer> getIdsOfPresentEntities(DefaultProductEntityJpaRepository repository) {
        return repository
                .findAll()
                .stream()
                .map(DefaultProductEntity::getId)
                .collect(Collectors.toList());
    }
}


