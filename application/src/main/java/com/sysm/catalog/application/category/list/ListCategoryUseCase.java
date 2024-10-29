package com.sysm.catalog.application.category.list;

import com.sysm.catalog.application.UseCase;
import com.sysm.catalog.domain.category.CategoryGateway;
import com.sysm.catalog.domain.category.CategorySearchQuery;
import com.sysm.catalog.domain.pagination.Pagination;

import java.util.Objects;

public class ListCategoryUseCase extends UseCase<CategorySearchQuery, Pagination<ListCategoryOutput>> {

    private final CategoryGateway categoryGateway;

    public ListCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Pagination<ListCategoryOutput> execute(final CategorySearchQuery aQuery) {
        return this.categoryGateway.findAll(aQuery)
            .map(ListCategoryOutput::from);
    }
}
