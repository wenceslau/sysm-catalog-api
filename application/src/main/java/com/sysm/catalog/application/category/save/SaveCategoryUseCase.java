package com.sysm.catalog.application.category.save;

import com.sysm.catalog.application.UseCase;
import com.sysm.catalog.domain.category.Category;
import com.sysm.catalog.domain.category.CategoryGateway;
import com.sysm.catalog.domain.exceptions.NotificationException;
import com.sysm.catalog.domain.exceptions.handler.Notification;
import com.sysm.catalog.domain.validation.Error;

import java.util.Objects;

public class SaveCategoryUseCase extends UseCase<Category, Category> {

    private final CategoryGateway categoryGateway;

    public SaveCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Category execute(final Category aCategory) {
        if (aCategory == null) {
            throw NotificationException.with(new Error("'aCategory' cannot be null"));
        }

        final var notification = Notification.create();
        aCategory.validate(notification);

        if (notification.hasError()) {
            throw NotificationException.with("Invalid category", notification);
        }

        return this.categoryGateway.save(aCategory);
    }
}
