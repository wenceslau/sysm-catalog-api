package com.sysm.catalog.infrastructure.category;

import com.sysm.catalog.domain.category.Category;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@CacheConfig(cacheNames = "admin-categories")
public class CategoryRestClient implements CategoryClient
    //, HttpClient
{
    @Override
    public Optional<Category> categoryOfId(String anId) {
        return Optional.empty();
    }
}
