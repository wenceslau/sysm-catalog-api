package com.sysm.catalog.infrastructure.category;

import com.sysm.catalog.AbstractElasticsearchTest;
import com.sysm.catalog.infrastructure.category.persistence.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryElasticsearchGatewayTest extends AbstractElasticsearchTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void test(){
        Assertions.assertNotNull(categoryRepository);
    }

}
