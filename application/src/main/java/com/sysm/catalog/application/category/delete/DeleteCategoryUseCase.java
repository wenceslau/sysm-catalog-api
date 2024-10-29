package com.sysm.catalog.application.category.delete;

import com.sysm.catalog.application.UnitUseCase;
import com.sysm.catalog.domain.category.CategoryGateway;

import java.util.Objects;

public class DeleteCategoryUseCase extends UnitUseCase<String> {

    private final CategoryGateway categoryGateway;

    public DeleteCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public void execute(final String anIn) {
        if (anIn == null) {
            return;
        }

        this.categoryGateway.deleteById(anIn);
    }
}
