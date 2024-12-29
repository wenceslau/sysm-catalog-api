package com.sysm.catalog;

import com.sysm.catalog.infrastructure.configuration.WebServerConfig;
import org.junit.jupiter.api.Tag;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchRepositoriesAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Inherited
@ActiveProfiles("test-integration")
@EnableAutoConfiguration(exclude = {
    ElasticsearchRepositoriesAutoConfiguration.class
})
@SpringBootTest(classes = {
    WebServerConfig.class,
    IntegrationTestConfiguration.class
})
@Tag("integration")
public @interface IntegrationTest {
}
