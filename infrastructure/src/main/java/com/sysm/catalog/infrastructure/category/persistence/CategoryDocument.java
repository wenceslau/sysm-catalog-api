package com.sysm.catalog.infrastructure.category.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.Instant;

@Document(indexName = "categories")
public class CategoryDocument {

    @Id
    private String id;


}
