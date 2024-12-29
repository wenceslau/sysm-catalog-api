package com.sysm.catalog;

import com.sysm.catalog.infrastructure.category.persistence.CategoryRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

// TODO: Create a test to remember that is required to create this bean
public class IntegrationTestConfiguration {

    @Bean
    public CategoryRepository categoryRepository() {
        return Mockito.mock(CategoryRepository.class);
    }
}
