package com.sysm.catalog.infrastructure.category;

import com.sysm.catalog.domain.category.Category;

import java.util.Optional;

public interface CategoryClient {

    Optional<Category> categoryOfId(String anId);
}
