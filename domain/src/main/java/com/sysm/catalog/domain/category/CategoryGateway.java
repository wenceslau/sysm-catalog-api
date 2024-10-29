package com.sysm.catalog.domain.category;


import com.sysm.catalog.domain.pagination.Pagination;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CategoryGateway {

    Category save(Category aCategory);

    void deleteById(String anId);

    Optional<Category> findById(String anId);

    List<Category> findAllById(Set<String> ids);

    Pagination<Category> findAll(CategorySearchQuery aQuery);

}
